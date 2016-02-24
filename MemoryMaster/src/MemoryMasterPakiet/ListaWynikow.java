package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;

public class ListaWynikow extends JComboBox {
		
	public ListaWynikow(){
		setEditable(false);
        setBorder(null);
        setOpaque(true);
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(0, 148, 255));
        setFont(new Font("Tahoma", Font.BOLD, 15));
        setMaximumRowCount(10);
	}
}
