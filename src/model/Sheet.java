package model;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

import expr.Environment;
import gui.SlotLabels;

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
		// TODO Auto-generated method stub
		return 0;
	}

	public Cell getCell(String key) {
		return null;
	}

	public String getCellValue(String key) {
		return null;
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
