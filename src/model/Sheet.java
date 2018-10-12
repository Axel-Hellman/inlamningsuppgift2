package model;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

import expr.Environment;
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

	public Cell getCell(String key) {
		return sheet.get(key);
	}

	public String getCellValue(String key) {

		Cell c = sheet.get(key);
		if (c == null) {
			return "";
		} else if (c instanceof CommentCell) {
			return c.getComment();
		}

		return String.valueOf(getCell(key).getValue(this)); // getValue returns a double - thereby the use of
															// String.valueOf
	}

	public String getStringValue() {
		return null;
	}

	public void put(String string, Cell cell) {

	}

	// Vet inte vad detta är, förklara.
	// public Set<Entry<String, Slot>> EntrySet(){
	//
	// }

	public int size() {
		return 0;
	}

	public void removeCell(String key) {

	}

	public void clearAll() {

	}

	public void updateSheet() {

	}

	public void putCell(String name, String text) {

	}

	public void load(HashMap<String, Cell> newSheet) {

	}

	private void checkLoop(String name, Cell cell) {

	}

	public void addSlotLabels(SlotLabels slotLabels) {

	}

	public void updateSlotLabels() {

	}
}
