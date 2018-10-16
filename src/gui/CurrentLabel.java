package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer{

    private CurrentCell currentCell;

    public CurrentLabel(CurrentCell currentCell) {
        super("A1", Color.WHITE);
        this.currentCell = currentCell;
        currentCell.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        setText(currentCell.getName());
    }
}