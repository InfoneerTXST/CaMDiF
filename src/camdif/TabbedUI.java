package camdif;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;

public class TabbedUI extends BasicTabbedPaneUI {

    private int tab = 3;

    public static ComponentUI createUI(JComponent c) {
        return new TabbedUI();
    }
    
    protected Insets getContentBorderInsets(int tabPlacement) {
		return new Insets(0, 0, 0, 0);
	}

    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2D = (Graphics2D)g;  
        int xp[] = new int[]{x, x, x, x + w - tab - 6, x + w - tab, x + w - tab, x + w - tab, x};
        int yp[] = new int[]{y + h, y , y, y, y, y, y + h, y + h};
        if(isSelected)
            g2D.setPaint(new GradientPaint(0, 0, new Color(220, 220, 220), 0, y + h / 2, new Color(220, 220, 220)));
        else
            g2D.setPaint(new GradientPaint(0, 0, new Color(205, 205, 205), 0, y + h / 2, new Color(205, 205, 205)));
        g2D.fill(new Polygon(xp, yp, xp.length));
    }

    protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
    	return 40;
    }

    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {}
}
