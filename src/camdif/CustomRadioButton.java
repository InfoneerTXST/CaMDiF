package camdif;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class CustomRadioButton extends JRadioButton {

	private ArrayList<String> chain;
	private int concept_count;
	
	public CustomRadioButton() {
		super();
		chain = new ArrayList<>();
		concept_count = 0;
		setIcon(new ImageIcon(getClass().getResource("/images/radio1.png")));
	    setSelectedIcon(new ImageIcon(getClass().getResource("/images/radio2.png")));
        setFocusable(false);
        this.setIconTextGap(8);
	}

	public CustomRadioButton(String text, boolean fill, Color background_color) {
		super(text);
		chain = new ArrayList<>();
		concept_count = 0;
		if(fill) {
			setIcon(new ImageIcon(getClass().getResource("/images/radio3.png")));
	        setSelectedIcon(new ImageIcon(getClass().getResource("/images/radio4.png")));
		}
		else {
			setIcon(new ImageIcon(getClass().getResource("/images/radio1.png")));
	        setSelectedIcon(new ImageIcon(getClass().getResource("/images/radio2.png")));
		}
        setFocusable(false);
        setBackground(background_color);
        this.setIconTextGap(8);
	}
	
	public CustomRadioButton(String text, ArrayList<String> chain, int concept_count, boolean fill, Color background_color) {
		super(text);
		this.chain = chain;
		this.concept_count = concept_count;
		if(fill) {
			setIcon(new ImageIcon(getClass().getResource("/images/radio3.png")));
	        setSelectedIcon(new ImageIcon(getClass().getResource("/images/radio4.png")));
		}
		else {
			setIcon(new ImageIcon(getClass().getResource("/images/radio1.png")));
	        setSelectedIcon(new ImageIcon(getClass().getResource("/images/radio2.png")));
		}
        setFocusable(false);
        setBackground(background_color);
        this.setIconTextGap(8);
	}
	
	public ArrayList<String> getChain() {
		return chain;
	}
	
	public int getConceptCount() {
		return concept_count;
	}
	
}
