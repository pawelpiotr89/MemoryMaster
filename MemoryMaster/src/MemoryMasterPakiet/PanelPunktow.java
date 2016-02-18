package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PanelPunktow extends JPanel{
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    
    final private int szerokoscRamki = screenSize.width;
    final private int wysokoscRamki = screenSize.height;
    final private double szerokoscPaneluPunktowDouble = szerokoscRamki * 0.2;
    final private int szerokoscPaneluPunktowInteger = (int) szerokoscPaneluPunktowDouble;
	
	public PanelPunktow(){
		setPreferredSize(new Dimension(szerokoscPaneluPunktowInteger, wysokoscRamki));
		setBackground(new Color(0, 148, 255));
	}
}
