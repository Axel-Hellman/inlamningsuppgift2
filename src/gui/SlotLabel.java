package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class SlotLabel extends ColoredLabel implements Observer, MouseListener {

    private String name;
    private CurrentCell currentCell;
    private Sheet sheet;
    private StatusLabel statusLabel;

    public SlotLabel(String name, CurrentCell currentCell, Sheet sheet, StatusLabel statusLabel) {
        super("                    ", Color.WHITE, RIGHT);
        this.name = name;
        this.currentCell = currentCell;
        this.sheet = sheet;
        addMouseListener(this);
        sheet.addObserver(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        String s = sheet.getCellValue(name);
        setText(s);
    }

    public void updateText() {
        String s = sheet.getCellValue(name);
        setText(s);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        currentCell.setWhite();
        setBackground(Color.YELLOW);
        currentCell.set(this);
        if(statusLabel != null) {
            statusLabel.clear();
        }
        System.out.println(currentCell.getName());
    }

    // Not used
    public void mousePressed(MouseEvent e) {
    }

    // Not used
    public void mouseReleased(MouseEvent e) {
    }

    // Not used
    public void mouseEntered(MouseEvent e) {
    }

    // Not used
    public void mouseExited(MouseEvent e) {
    }
}