package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public abstract class Przycisk extends JButton {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
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
		setForeground(new Color(0,0,0));
		setPreferredSize(new Dimension(szerokoscPrzyciskuInteger,wysokoscPrzyciskuInteger));
		
		addMouseListener(new MouseAdapter(){
			@Override
            public void mouseEntered(MouseEvent e){
                setForeground(new Color(0,148,255));   
            }
            
            @Override
            public void mouseExited(MouseEvent e){ 
                setForeground(new Color(0,0,0));  
            }
        });
	}	
}
