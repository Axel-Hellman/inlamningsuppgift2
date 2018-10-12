package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import model.Sheet;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, CurrentCell currentCell, Sheet sheet, StatusLabel statusLabel) {
        add(WEST, new RowLabels(rows));
        slotLabels = new SlotLabels(rows, columns, currentCell, sheet, statusLabel);
        add(CENTER, slotLabels);//implement
        sheet.addSlotLabels(slotLabels);
    }
}