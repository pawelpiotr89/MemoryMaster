package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Ramka extends JFrame {
	
	PanelMenu panelMenu = new PanelMenu();
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    final private int szerokoscRamki = screenSize.width;
    final private int wysokoscRamki = screenSize.height;
	
	public Ramka(){
		setPreferredSize(new Dimension(szerokoscRamki, wysokoscRamki));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setTitle("Memory_Master");
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		add(panelMenu);
		pack();
		setVisible(true);	
	}
}
