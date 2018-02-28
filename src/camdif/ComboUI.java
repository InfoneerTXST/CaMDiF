package camdif;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class ComboUI extends BasicComboBoxUI {
	
	private JComboBox combo_box;
	private boolean show_arrow;
	private Color track_color;
	
	public ComboUI(JComboBox combo_box, boolean show_arrow, Color track_color) {
		this.combo_box = combo_box;
		this.show_arrow = show_arrow;
		this.track_color = track_color;
	}
	
	@Override
	protected JButton createArrowButton() {
		if(show_arrow)
		{
			JButton button = new JButton();
			button.setText("\u25BE");
			button.setBorder(BorderFactory.createEmptyBorder());
			button.setUI(new BasicButtonUI());
			return button;
		}
		return null;
    }
	
	@Override
    protected ComboPopup createPopup() {
        BasicComboPopup bcp = new BasicComboPopup(combo_box) {
            @Override
            protected JScrollPane createScroller() {
                JScrollPane scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scroll.getVerticalScrollBar().setUI(new ScrollUI(track_color));
                return scroll;
            }
        };
        bcp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        return bcp;
	}
	
}
