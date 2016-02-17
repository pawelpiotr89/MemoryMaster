package MemoryMasterPakiet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    final private int szerokoscEkranu = screenSize.width;
    final private int wysokoscEkranu = screenSize.height;
    final private double odstepRamkiDouble = szerokoscEkranu/6;
    final private int odstepRamkiInteger = (int) odstepRamkiDouble;
    final private double odstepPrzyciskuDouble = szerokoscEkranu/40;
    final private int odstepPrzyciskuInteger = (int) odstepPrzyciskuDouble;
	
	PrzyciskStart przyciskStart = new PrzyciskStart();
	PrzyciskExit przyciskExit = new PrzyciskExit();
	
	public PanelMenu(){
		setBackground(Color.WHITE);
		add(Box.createRigidArea(new Dimension(1, odstepRamkiInteger)));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		przyciskStart.setAlignmentX(PanelMenu.CENTER_ALIGNMENT);
		add(przyciskStart);
		add(Box.createRigidArea(new Dimension(1, odstepPrzyciskuInteger)));
		przyciskExit.setAlignmentX(PanelMenu.CENTER_ALIGNMENT);
		add(przyciskExit);
	}
}
