package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class PanelKart extends JPanel {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    
    final private int szerokoscRamki = screenSize.width;
    final private int wysokoscRamki = screenSize.height;
    final private double szerokoscPaneluKartDouble = szerokoscRamki * 0.8;
    final private int szerokoscPaneluKartInteger = (int) szerokoscPaneluKartDouble;
    final private double odstepPionowyDouble = wysokoscRamki * 0.05;
    final private int odstepPionowyInteger = (int) odstepPionowyDouble;
    final private double odstepPoziomyDouble = szerokoscRamki * 0.05;
    final private int odstepPoziomyInteger = (int) odstepPoziomyDouble;
	
	public PanelKart(){
		setPreferredSize(new Dimension(szerokoscPaneluKartInteger, wysokoscRamki));
		setLayout(new GridLayout(8,6, odstepPoziomyInteger, odstepPionowyInteger));
		setBackground(Color.WHITE);
	}
}
