package model;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

import expr.Environment;
import gui.SlotLabel;
import gui.SlotLabels;
import util.XLException;

public class Sheet extends Observable implements Environment {

	private HashMap<String, Cell> sheet;
	private Factory factory;
	private SlotLabels slotLabels;

	public Sheet() {
		super();
		sheet = new HashMap<String, Cell>();
		factory = new Factory();
	}

	public Sheet(HashMap<String, Cell> sheet) {
		this.sheet = sheet;

	}

	@Override
	public double value(String name) {

		Cell cell = sheet.get(name);
		if (cell == null) {
			throw new XLException("Error: " + name + " is empty");
		}

		return cell.getValue(this);
	}
	
	public Set<Entry<String, Cell>> entrySet(){
		return sheet.entrySet();
	}

	public Cell getCell(String key) {
		return sheet.get(key);
	}

	public String getCellValue(String key) {

		Cell c = getCell(key);
		if (c == null) {
			return "";
		} else if (c instanceof CommentCell) {
			return c.getComment();
		}

		return String.valueOf(getCell(key).getValue(this)); // getValue returns
															// a double -
															// thereby the use
															// of
															// String.valueOf
	}

	public String getStringValue(String key) {
		Cell c = getCell(key);
		if (c == null) {
			return "";
		}

		return c.toString(this);
	}

	public void put(String string, Cell cell) {
		sheet.put(string, cell);
		updateSheet();
	}

	public Set<Entry<String, Cell>> EntrySet() {
		return sheet.entrySet();
	}

	public int size() {
		return sheet.size();
	}

	public void removeCell(String key) {
		Cell cell = sheet.get(key);
		Cell bombCell = new Bomb();
		sheet.put(key, bombCell);
		try {
			for (Cell c : sheet.values()) {
				if (c != bombCell) {
					c.getValue(this);
				}
			}
		} catch (XLException e) {
			sheet.put(key, cell);
			throw new XLException("Cannot remove cell " + key);
		}
		sheet.remove(key);
		updateSheet();
	}

	public void clearAll() {
		sheet = new HashMap<String, Cell>();
		slotLabels.clearAll();
		updateSheet();
	}

	public void updateSheet() {
		setChanged();
		notifyObservers();
	}

	public void putCell(String name, String cellText) {
		Cell cell = factory.cell(cellText);
		checkBomb(name, cell);
		sheet.put(name, cell);
		updateSheet();
	}

	public void load(HashMap<String, Cell> newSheet) {
		HashMap<String, Cell> prevSheet = sheet;
		sheet = newSheet;
		try {
			for (Entry<String, Cell> entry : sheet.entrySet()) {
				checkBomb(entry.getKey(), entry.getValue());
			}
		} catch (XLException e) {
			sheet = prevSheet;
			throw e;
		}
		updateSheet();
	}

	private void checkBomb(String name, Cell cell) {
		Cell prevCell = sheet.get(name);
		Cell bombCell = new Bomb();
		sheet.put(name, bombCell);
		try {
			cell.getValue(this);
		} finally {
			sheet.put(name, prevCell);
		}
	}

	public void addSlotLabels(SlotLabels slotLabels) {
		this.slotLabels = slotLabels;
	}

	public void updateSlotLabels() {
		for (SlotLabel s : slotLabels.getList()) {
			s.updateText();
		}
	}
}
