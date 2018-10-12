package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import model.Sheet;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
	private Sheet sheet;
	
    public ClearAllMenuItem() {
        super("Clear all");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        sheet.clearAll();
    }
}