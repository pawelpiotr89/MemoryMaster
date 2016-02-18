package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class PrzyciskMenu extends Przycisk {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    final private int szerokoscEkranu = screenSize.width;
    final private int wysokoscEkranu = screenSize.height;
    final private double szerokoscPrzyciskuDouble = szerokoscEkranu * 0.2;
    final private double wysokoscPrzyciskuDouble = wysokoscEkranu / 20;
    final private int szerokoscPrzyciskuInteger = (int) szerokoscPrzyciskuDouble;
    final private int wysokoscPrzyciskuInteger = (int) wysokoscPrzyciskuDouble;
	
	public PrzyciskMenu(){
		setText("MAIN_MENU");
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setContentAreaFilled(true);
		setMaximumSize(new Dimension(szerokoscPrzyciskuInteger, wysokoscPrzyciskuInteger));
	}
}
