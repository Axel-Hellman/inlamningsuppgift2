package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class StatusLabel extends ColoredLabel implements Observer {
	Sheet sheet;
	
    public StatusLabel() {
        super("", Color.WHITE);
        sheet = new Sheet();
        sheet.addObserver(this);
    }

    public void update(Observable observable, Object object) {
        setText("");
    }
    
    public void clear() {
    	setText("");
    }
}