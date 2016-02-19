package MemoryMasterPakiet;

import java.awt.Color;

import javax.swing.JButton;

public abstract class Karta extends JButton {
	
	public Karta(){
		setOpaque(true);
		setBorderPainted(true);
		setBackground(new Color(0, 148, 255));
		setEnabled(true);
	}
	
	
}
