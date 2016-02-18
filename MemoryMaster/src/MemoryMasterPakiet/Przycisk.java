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

import javax.swing.JButton;

public abstract class Przycisk extends JButton {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    Image imagePalecPrzycisk = tk.getImage("src\\MemoryMasterPakiet\\kursor1.png");
	Image imagePiescPrzycisk = tk.getImage("src\\MemoryMasterPakiet\\kursor2.png");
	
    final private int szerokoscEkranu = screenSize.width;
    final private int wysokoscEkranu = screenSize.height;
    final private double szerokoscPrzyciskuDouble = wysokoscEkranu/50;
    final private double wysokoscPrzyciskuDouble = szerokoscEkranu/100;
    final private int szerokoscPrzyciskuInteger = (int) szerokoscPrzyciskuDouble;
    final private int wysokoscPrzyciskuInteger = (int) wysokoscPrzyciskuDouble;
    final private double rozmiarCzcionkiDouble = szerokoscEkranu/100;
    final private int rozmiarCzcionkiInteger = (int) rozmiarCzcionkiDouble;
	
	public Przycisk(){
		setOpaque(true);
		setBorderPainted(false);
		setEnabled(true);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setFont(new Font("Tahoma", Font.BOLD, rozmiarCzcionkiInteger));
		setBackground(Color.WHITE);
		setForeground(new Color(0, 0, 0));
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
		Cursor a = tk.createCustomCursor(imagePalecPrzycisk , new Point(), "");
    	setCursor (a);
	}
	
	public void nacisniecieKursora(){
    	Cursor a = tk.createCustomCursor(imagePiescPrzycisk , new Point(), "");
    	setCursor (a);
	}
}
