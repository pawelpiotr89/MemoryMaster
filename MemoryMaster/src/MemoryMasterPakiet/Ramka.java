package MemoryMasterPakiet;

import java.awt.Color;
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
    final private int szerokoscRamki = screenSize.width;
    final private int wysokoscRamki = screenSize.height;
    final private double odstepRamkiDouble = szerokoscRamki/6;
    final private int odstepRamkiInteger = (int) odstepRamkiDouble;
    final private double odstepPrzyciskuDouble = szerokoscRamki/40;
    final private int odstepPrzyciskuInteger = (int) odstepPrzyciskuDouble;
    
    Toolkit toolkit = Toolkit.getDefaultToolkit();
	Image image1 = toolkit.getImage("src\\MemoryMasterPakiet\\kursor1.png");
	Image image2 = toolkit.getImage("src\\MemoryMasterPakiet\\kursor2.png");
    
    PrzyciskStart przyciskStart = new PrzyciskStart();
	PrzyciskExit przyciskExit = new PrzyciskExit();
	PanelMenu panelMenu = new PanelMenu();
	PanelGry panelGry = new PanelGry();
	
	public Ramka(){
		setPreferredSize(new Dimension(szerokoscRamki, wysokoscRamki));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setTitle("Memory_Master");
		setUndecorated(true);
		
		add(panelMenu);
		panelMenu.add(Box.createRigidArea(new Dimension(1, odstepRamkiInteger)));
		przyciskStart.setAlignmentX(PanelMenu.CENTER_ALIGNMENT);
		panelMenu.add(przyciskStart);
		panelMenu.add(Box.createRigidArea(new Dimension(1, odstepPrzyciskuInteger)));
		przyciskExit.setAlignmentX(PanelMenu.CENTER_ALIGNMENT);
		panelMenu.add(przyciskExit);
		
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
		
		getContentPane().setBackground(Color.WHITE);
		pack();
		setVisible(true);	
	}
	
	public void startMemoryMaster(){
		usunieciePaneluMenu();
		dodaniePaneluGry();
		rewalidacja();
		odmalowanie();
	}
		public void usunieciePaneluMenu(){
		remove(panelMenu);
		}
		public void dodaniePaneluGry(){
		add(panelGry);
		}
		public void rewalidacja(){
		revalidate();
		}
		public void odmalowanie(){
		repaint();
		}
	
	public void exitMemoryMaster(){
		System.exit(0);
	}
	
	public void tworzenieKursora(){
		Cursor a = toolkit.createCustomCursor(image1 , new Point(getX(),getY()), "");
    	setCursor (a);
	}
	
	public void nacisniecieKursora(){
    	Cursor a = toolkit.createCustomCursor(image2 , new Point(getX(),getY()), "");
    	setCursor (a);
	}
}
