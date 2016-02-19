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
    final private double szerokoscPaneluKartDouble = szerokoscRamki * 0.79;
    final private int szerokoscPaneluKartInteger = (int) szerokoscPaneluKartDouble;
    final private double odstepPionowyDouble = wysokoscRamki * 0.005;
    final private int odstepPionowyInteger = (int) odstepPionowyDouble;
    final private double odstepPoziomyDouble = szerokoscRamki * 0.005;
    final private int odstepPoziomyInteger = (int) odstepPoziomyDouble;
    
    KartaPierwsza kartaPierwsza = new KartaPierwsza();
    KartaDruga kartaDruga = new KartaDruga();
    KartaTrzecia kartaTrzecia = new KartaTrzecia();
    KartaCzwarta kartaCzwarta = new KartaCzwarta();
    KartaPiata kartaPiata = new KartaPiata();
	KartaSzosta kartaSzosta = new KartaSzosta();
	KartaSiodma kartaSiodma = new KartaSiodma();
	KartaOsma kartaOsma = new KartaOsma();
    
	public PanelKart(){
		setPreferredSize(new Dimension(szerokoscPaneluKartInteger, wysokoscRamki));
		setLayout(new GridLayout(6,8, odstepPoziomyInteger, odstepPionowyInteger));
		setBackground(Color.WHITE);
		
		add(kartaPierwsza);
		add(kartaDruga);
		add(kartaTrzecia);
		add(kartaCzwarta);
		add(kartaPiata);
		add(kartaSzosta);
		add(kartaSiodma);
		add(kartaOsma);
	}
}
