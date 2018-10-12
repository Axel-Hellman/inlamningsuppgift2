package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.Cell;
import model.Sheet;
import util.XLBufferedReader;

import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {
	private Sheet sheet;
 
    public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Load");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
        statusLabel.clear();
        try {
        	XLBufferedReader XLbr = new XLBufferedReader(path);
        	HashMap<String, Cell> temp = new HashMap<String, Cell>();
        	XLbr.load(temp);
        	System.out.println(temp.size());
        	sheet.clearAll();
        	sheet.load(temp);
        	sheet.updateSlotLabels();
        } catch(Exception e) {
        	statusLabel.setText(e.getMessage());
        }
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}