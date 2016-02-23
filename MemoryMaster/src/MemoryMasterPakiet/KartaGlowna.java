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

public abstract class KartaGlowna extends JButton{
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    
    URL palec = Ramka.class.getResource("kursor1.png");
    URL piesc = Ramka.class.getResource("kursor2.png");
    
    Image imagePalec = tk.getImage(palec);
	Image imagePiesc = tk.getImage(piesc);
    
    final private int szerokoscRamki = screenSize.width;
    final private double wymiarCzcionkiDouble = szerokoscRamki* 0.05;
    final private int wymiarCzcionkiInteger = (int) wymiarCzcionkiDouble;
  
	public KartaGlowna(){
		setOpaque(true);
		setBorderPainted(true);
		setBackground(new Color(75, 181, 48));
		setEnabled(true);
		setFocusPainted(false);
		setFont(new Font("Verdana", Font.BOLD, wymiarCzcionkiInteger));
	
	addMouseListener(new MouseAdapter(){
		
        public void mousePressed(MouseEvent e){
        	nacisniecieKursora();	
        }
        
		public void mouseReleased(MouseEvent e){
			tworzenieKursora();	
		}
			
		public void mouseClicked(MouseEvent e) {	
		}	
	});
	}
	
		public void tworzenieKursora(){
		Cursor a = tk.createCustomCursor(imagePalec , new Point(), "");
		setCursor (a);
		}

		public void nacisniecieKursora(){
		Cursor a = tk.createCustomCursor(imagePiesc , new Point(), "");
		setCursor (a);
		}
		
		public void ustawBialeTlo(){
			setBackground(Color.WHITE);
		}
		
		public void ustawZieloneTlo(){
			setBackground(new Color(75, 181, 48));
		}
		
		public void zablokowanieKarty(){
			this.setEnabled(false);
		}
		
		public void odblokowanieKarty(){
			this.setEnabled(true);
		}
}
