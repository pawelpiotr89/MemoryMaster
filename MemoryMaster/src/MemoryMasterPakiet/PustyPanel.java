package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PustyPanel extends JPanel{
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    
    final private int szerokoscRamki = screenSize.width;
    final private int wysokoscRamki = screenSize.height;
    final private double szerokoscPustegoPaneluDouble = szerokoscRamki * 0.01;
    final private int szerokoscPustegoPaneluInteger = (int) szerokoscPustegoPaneluDouble;
	
	public PustyPanel(){
		setPreferredSize(new Dimension(szerokoscPustegoPaneluInteger, wysokoscRamki));
		setBackground(Color.WHITE);
	}
}
