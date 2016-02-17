package MemoryMasterPakiet;

import javax.swing.SwingUtilities;

public class KlasaGlowna {

	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable(){
			
            public void run() {
            	new Ramka();
            }
		});
	}
}
