package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;

import com.sun.xml.internal.bind.v2.runtime.Name;

import model.Sheet;

public class SlotLabels extends GridPanel {
	private List<SlotLabel> labelList;
	private CurrentCell currentCell;
	private Sheet sheet;
	private StatusLabel statusLabel;

	public SlotLabels(int rows, int cols, CurrentCell currentSlot, Sheet sheet, StatusLabel statusLabel) {
		super(rows + 1, cols);
		this.currentCell = currentSlot;
		this.sheet = sheet;
		this.statusLabel = statusLabel;

		labelList = new ArrayList<SlotLabel>(rows * cols);
		for (char ch = 'A'; ch < 'A' + cols; ch++) {
			add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY, SwingConstants.CENTER));
		}

		for (int row = 1; row <= rows; row++) {
			for (char ch = 'A'; ch < 'A' + cols; ch++) {
				String name = ch + String.valueOf(row);
				SlotLabel label = new SlotLabel(name, currentSlot, sheet, statusLabel);
				add(label);
				labelList.add(label);
			}
		}
		SlotLabel firstLabel = labelList.get(0); // <- SÄTTER FÖRSTA LABELN
		firstLabel.setBackground(Color.YELLOW);
		currentCell.set(firstLabel);
	}

	public void clearAll() {
		for (SlotLabel sl : labelList) {
			sl.setText("");
		}
	}

	public List<SlotLabel> getList() {
		return labelList;
	}

}
