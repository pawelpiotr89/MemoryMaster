package MemoryMasterPakiet;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.JFrame;

public class Ramka extends JFrame {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    Image imagePalec = tk.getImage("src\\MemoryMasterPakiet\\kursor1.png");
	Image imagePiesc = tk.getImage("src\\MemoryMasterPakiet\\kursor2.png");
	
    final private int szerokoscRamki = screenSize.width;
    final private int wysokoscRamki = screenSize.height;
    final private double odstepRamkiDouble = szerokoscRamki/6;
    final private int odstepRamkiInteger = (int) odstepRamkiDouble;
    final private double odstepPrzyciskuDouble = szerokoscRamki/40;
    final private int odstepPrzyciskuInteger = (int) odstepPrzyciskuDouble;
  
    PrzyciskStart przyciskStart = new PrzyciskStart();
	PrzyciskExit przyciskExit = new PrzyciskExit();
	PrzyciskMenu przyciskMenu = new PrzyciskMenu();
	PrzyciskMieszanie przyciskMieszanie = new PrzyciskMieszanie();
	PanelMenu panelMenu = new PanelMenu();
	PanelGry panelGry = new PanelGry();
	PanelKart panelKart = new PanelKart();
	PanelPunktow panelPunktow = new PanelPunktow();
	Stoper stoper = new Stoper();
	
	public Ramka(){
		setPreferredSize(new Dimension(szerokoscRamki, wysokoscRamki));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Memory_Master");
		setUndecorated(true);
		
		panelMenu.add(Box.createRigidArea(new Dimension(1, odstepRamkiInteger)));
		panelMenu.add(przyciskStart);
		panelMenu.add(Box.createRigidArea(new Dimension(1, odstepPrzyciskuInteger)));
		panelMenu.add(przyciskExit);
		
		panelPunktow.add(przyciskMenu);
		panelPunktow.add(stoper);
		panelPunktow.add(przyciskMieszanie);
	
		panelGry.add(panelKart, BorderLayout.WEST);
		panelGry.add(panelPunktow, BorderLayout.EAST);
		add(panelMenu);
		
		addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseEntered(MouseEvent e){
	        	tworzenieKursora();  
	        }
	        
	        @Override
	        public void mousePressed(MouseEvent e){
	        	nacisniecieKursora();  
	        }
	        
	        @Override
	        public void mouseReleased(MouseEvent e){
	        	tworzenieKursora();  
	        }
	    });
		
		przyciskStart.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 startMemoryMaster();
		     }
		});
		
		przyciskExit.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 exitMemoryMaster();
		     }
		});
		
		przyciskMenu.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 sprawdzeniePrzycisku();
		    	 powrotDoMenu();
		     }
		});
		
		przyciskMieszanie.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 stoper.startCzas();
		    	 przyciskMieszanie.zamorzeniePrzycisku();
		     }
		});
		
		getContentPane();
		pack();
		setVisible(true);	
	}
	
	public void tworzenieKursora(){
		Cursor a = tk.createCustomCursor(imagePalec , new Point(), "");
    	setCursor (a);
	}
	
	public void nacisniecieKursora(){
    	Cursor a = tk.createCustomCursor(imagePiesc , new Point(), "");
    	setCursor (a);
	}
	
	public void exitMemoryMaster(){
		System.exit(0);
	}
	
	public void startMemoryMaster(){
		usunieciePaneluMenu();
		dodaniePaneluGry();
		czyszczeniePanelu();
	}
	
	public void powrotDoMenu(){
		usunieciePaneluGry();
		dodaniePaneluMenu();
		czyszczeniePanelu();
	}
	
		public void usunieciePaneluMenu(){
			remove(panelMenu);
		}
		
		public void dodaniePaneluGry(){
			add(panelGry);
		}
		
		public void usunieciePaneluGry(){
			remove(panelGry);
		}
		
		public void dodaniePaneluMenu(){
			add(panelMenu);
		}
		
		public void czyszczeniePanelu(){
			revalidate();
			repaint();	
		}
		
		public void sprawdzeniePrzycisku(){
			if(stoper.sprawdzenieCzyDziala()){
	    		 stoper.stopCzas();
		    	 przyciskMieszanie.odmrorzeniePrzycisku();	 
	    	 }
		}
}
