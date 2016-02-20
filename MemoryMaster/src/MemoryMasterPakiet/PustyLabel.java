package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;

public class PustyLabel extends JLabel {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    
    final private int szerokoscRamki = screenSize.width;
    final private int wysokoscRamki = screenSize.height;
    final private double szerokoscEtykietyCzasDouble = szerokoscRamki * 0.2;
    final private int szerokoscEtykietyCzasInteger = (int) szerokoscEtykietyCzasDouble;
    final private double wysokoscEtykietyCzasDouble = wysokoscRamki / 20;
    final private int wysokoscEtykietyCzasInteger = (int) wysokoscEtykietyCzasDouble;
	
	public PustyLabel(){
		setBackground(Color.WHITE);
		setMaximumSize(new Dimension(szerokoscEtykietyCzasInteger, wysokoscEtykietyCzasInteger));
		setOpaque(true);
	}
}

