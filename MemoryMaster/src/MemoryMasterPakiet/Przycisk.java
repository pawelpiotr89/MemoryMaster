package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JButton;

public abstract class Przycisk extends JButton {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    
    URL palec = Ramka.class.getResource("kursor1.png");
    URL piesc = Ramka.class.getResource("kursor2.png");
    
    Image imagePalec = tk.getImage(palec);
	Image imagePiesc = tk.getImage(piesc);
	
    final private int szerokoscEkranu = screenSize.width;
    final private int wysokoscEkranu = screenSize.height;
    final private double szerokoscPrzyciskuDouble = szerokoscEkranu / 100;
    final private double wysokoscPrzyciskuDouble = wysokoscEkranu / 10;
    final private int szerokoscPrzyciskuInteger = (int) szerokoscPrzyciskuDouble;
    final private int wysokoscPrzyciskuInteger = (int) wysokoscPrzyciskuDouble;
    final private int rozmiarCzcionkiInteger = (int) szerokoscPrzyciskuDouble;
	
	public Przycisk(){
		setOpaque(true);
		setBorderPainted(false);
		setEnabled(true);
		setFocusPainted(false);
		setForeground(Color.BLACK);
		setFont(new Font("Tahoma", Font.BOLD, rozmiarCzcionkiInteger));
		setPreferredSize(new Dimension(szerokoscPrzyciskuInteger,wysokoscPrzyciskuInteger));
		
		addMouseListener(new MouseAdapter(){
			@Override
            public void mouseEntered(MouseEvent e){
				ustawienieTekstuNaNiebiesko();
            }
            
            @Override
            public void mouseExited(MouseEvent e){ 
            	ustawienieTekstuNaCzarno();
            }
            
            @Override
	        public void mousePressed(MouseEvent e){
	        	nacisniecieKursora();
	        	ustawienieTekstuNaCzarno();
	        }
      
			@Override
			public void mouseReleased(MouseEvent e){
				tworzenieKursora();
				ustawienieTekstuNaCzarno();
			}
		});
	}
	
	public void ustawienieTekstuNaNiebiesko(){
		setForeground(new Color(0, 148, 255));
	}
	
	public void ustawienieTekstuNaCzarno(){
		setForeground(new Color(0, 0, 0));
	}
	
	public void tworzenieKursora(){
		Cursor a = tk.createCustomCursor(imagePalec , new Point(), "");
    	setCursor (a);
	}
	
	public void nacisniecieKursora(){
    	Cursor a = tk.createCustomCursor(imagePiesc , new Point(), "");
    	setCursor (a);
	}
}
