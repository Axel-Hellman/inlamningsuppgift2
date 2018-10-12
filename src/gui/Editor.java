package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Sheet;
import util.XLException;

public class Editor extends JTextField implements ActionListener, Observer {
	Sheet sheet;
	StatusLabel statusLabel;
	CurrentCell currentCell;

	public Editor(CurrentCell currentCell, StatusLabel statusLabel, Sheet sheet) {
		setBackground(Color.WHITE);
		this.sheet = sheet;
		this.statusLabel = statusLabel;
		this.currentCell = currentCell;
		addActionListener(this);
		currentCell.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		String key = currentCell.getName();
		String stringValue = sheet.getStringValue(key);
		setText(stringValue);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// statusLabel.clear();
		String key = currentCell.getName();
		if (getText().equals("")) {
			try {
				sheet.removeCell(key);
			} catch (XLException e1) {
				statusLabel.setText(e1.getMessage());
			}
		} else {
			try {
				sheet.putCell(key, getText());
			} catch (XLException e2) {
				statusLabel.setText(e2.getMessage());
			}
		}
	}
}