package camdif;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class RadioButtonListRenderer extends CustomRadioButton implements ListCellRenderer<CustomRadioButton> {

	@Override
	public Component getListCellRendererComponent(JList<? extends CustomRadioButton> list, CustomRadioButton value, int index, boolean isSelected, boolean cellHasFocus) {
		setEnabled(list.isEnabled());
		setSelected(isSelected);
		value.setSelected(isSelected);
		setFont(list.getFont());
		setBackground(list.getBackground());
		setForeground(list.getForeground());
		setText(value.getText());
		return this;
	}
	
}
