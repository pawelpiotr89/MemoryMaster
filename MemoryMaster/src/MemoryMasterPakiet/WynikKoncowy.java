package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;

public class WynikKoncowy extends JLabel {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    
    final private int szerokoscRamki = screenSize.width;
    final private int wysokoscRamki = screenSize.height;
    final private double szerokoscEtykietyCzasDouble = szerokoscRamki * 0.2;
    final private int szerokoscEtykietyCzasInteger = (int) szerokoscEtykietyCzasDouble;
    final private double wysokoscEtykietyCzasDouble = wysokoscRamki / 20;
    final private int wysokoscEtykietyCzasInteger = (int) wysokoscEtykietyCzasDouble;
    final private double rozmiarCzcionkiDouble = szerokoscRamki / 50;
    final private int rozmiarCzcionkiInteger = (int) rozmiarCzcionkiDouble;
	
	public WynikKoncowy(){
		setForeground(new Color(0, 148, 255));
		setBackground(new Color(255, 255, 255));
		setMaximumSize(new Dimension(szerokoscEtykietyCzasInteger, wysokoscEtykietyCzasInteger));
		setFont(new Font("Tahoma", Font.BOLD, rozmiarCzcionkiInteger));
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setText("0");
	}
}

