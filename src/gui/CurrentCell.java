package gui;

import java.awt.Color;
import java.util.Observable;

public class CurrentCell extends Observable {
	private SlotLabel currentCell;
	
	public CurrentCell(){
		
	}
	
	public String getName() {
		return currentCell.getName();
	}

	public void set(SlotLabel slotLabel) {
		currentCell = slotLabel;
		setChanged();
		notifyObservers();
		// addObserver(slotLabel);
	}

	public void setWhite() {
		currentCell.setBackground(Color.WHITE);
	}

	public void clearSlot() {
		currentCell.setText("");
	}
}
