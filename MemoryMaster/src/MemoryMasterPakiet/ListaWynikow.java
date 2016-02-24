package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JComboBox;

public class ListaWynikow extends JComboBox {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	URL palec = Ramka.class.getResource("kursor1.png");
    URL piesc = Ramka.class.getResource("kursor2.png");
    
    Image imagePalec = tk.getImage(palec);
	Image imagePiesc = tk.getImage(piesc);
	
	public ListaWynikow(){
		setEditable(false);
        setBorder(null);
        setOpaque(true);
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(0, 148, 255));
        setFont(new Font("Tahoma", Font.BOLD, 15));
        setMaximumRowCount(10);
        
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
