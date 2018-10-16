package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import gui.CurrentCell;
import model.Sheet;

class ClearMenuItem extends JMenuItem implements ActionListener {
		private Sheet sheet;//comment
		
	private CurrentCell currentCell;
	
    public ClearMenuItem(CurrentCell currentCell, Sheet sheet) {
        super("Clear");
        this.sheet = sheet;
        this.currentCell = currentCell;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        sheet.removeCell(currentCell.getName());
    }
}