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

public abstract class KartaGlowna extends JButton {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    Image imagePalecPrzycisk = tk.getImage("src\\MemoryMasterPakiet\\kursor1.png");
	Image imagePiescPrzycisk = tk.getImage("src\\MemoryMasterPakiet\\kursor2.png");
    
    final private int szerokoscRamki = screenSize.width;
    final private double wymiarCzcionkiDouble = szerokoscRamki* 0.05;
    final private int wymiarCzcionkiInteger = (int) wymiarCzcionkiDouble;
   
	public KartaGlowna(){
		setOpaque(true);
		setBorderPainted(true);
		setBackground(new Color(75, 181, 48));
		setEnabled(true);
		setFocusPainted(true);
		setFont(new Font("Verdana", Font.BOLD, wymiarCzcionkiInteger));
	
	addMouseListener(new MouseAdapter(){
		
        @Override
        public void mousePressed(MouseEvent e){
        	nacisniecieKursora();	
        }
  
		@Override
		public void mouseReleased(MouseEvent e){
			tworzenieKursora();	
		}
	});
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
