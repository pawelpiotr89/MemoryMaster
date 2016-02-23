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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

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
    
    private double score = 0;
  
    PrzyciskStart przyciskStart = new PrzyciskStart();
	PrzyciskExit przyciskExit = new PrzyciskExit();
	PrzyciskMenu przyciskMenu = new PrzyciskMenu();
	PrzyciskWyniki przyciskWyniki = new PrzyciskWyniki();
	PrzyciskMieszanie przyciskMieszanie = new PrzyciskMieszanie();
	PrzyciskScorePowrot przyciskScorePowrot = new PrzyciskScorePowrot();
	PanelMenu panelMenu = new PanelMenu();
	PanelGry panelGry = new PanelGry();
	PanelKart panelKart = new PanelKart();
	PanelPunktow panelPunktow = new PanelPunktow();
	PanelWynikow panelWynikow = new PanelWynikow();
	PustyPanel pustyPanel = new PustyPanel();
	NapisCzas napisCzas = new NapisCzas();
	Stoper stoper = new Stoper();
	NapisKlikniecia napisKlikniecia = new NapisKlikniecia();
	LicznikKlikniec licznikKlikniec = new LicznikKlikniec();
	LabelWyniku labelWyniku = new LabelWyniku();
	WynikKoncowy wynikKoncowy = new WynikKoncowy();
	
	Timer timer2;
	
	String tekst = "";
	String stringToTXT = "";
	String stringOstateczny = "";
	
	public Ramka(){
		setPreferredSize(new Dimension(szerokoscRamki, wysokoscRamki));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(false);
		setTitle("Memory_Master");
		setUndecorated(true);
		
		panelMenu.add(Box.createRigidArea(new Dimension(1, odstepRamkiInteger)));
		panelMenu.add(przyciskStart);
		panelMenu.add(Box.createRigidArea(new Dimension(1, odstepPrzyciskuInteger)));
		panelMenu.add(przyciskWyniki);
		panelMenu.add(Box.createRigidArea(new Dimension(1, odstepPrzyciskuInteger)));
		panelMenu.add(przyciskExit);
		
		panelPunktow.add(przyciskMenu);
		panelPunktow.add(napisCzas);
		panelPunktow.add(stoper);
		panelPunktow.add(labelWyniku);
		panelPunktow.add(wynikKoncowy);
		panelPunktow.add(napisKlikniecia);
		panelPunktow.add(licznikKlikniec);
		panelPunktow.add(przyciskMieszanie);
		
		panelWynikow.add(Box.createRigidArea(new Dimension(1, odstepPrzyciskuInteger)));
		panelWynikow.add(przyciskScorePowrot);
		panelWynikow.add(Box.createRigidArea(new Dimension(1, odstepPrzyciskuInteger)));
	
		panelGry.add(panelKart, BorderLayout.WEST);
		panelGry.add(pustyPanel, BorderLayout.CENTER);
		panelGry.add(panelPunktow, BorderLayout.EAST);
		add(panelMenu);
		
		timer2 = new Timer(1, new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	licznikKlikniec.setText("" + panelKart.getLiczbaProb());
		    	wynikKoncowy.setText(obliczWynikKoncowy() + "");
		    		if(panelKart.getKoniecGry() == true && stoper.sprawdzenieCzyDziala() == true){
		    			stoper.stopTimer();
		    			stoper.stopStoper();
		    				tekst = JOptionPane.showInputDialog("Congratulations_you_scored_" + wartoscPunktowDoString() + "_points._Set_your_nick/name.");
		    				operacjeNaOkienku();
		    			removeStart();
		    		}
		    }
		});
		
		
		
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
		    	 if(!timer2.isRunning()){
		    		 timer2.start();
		    	 }
		    	 startMemoryMaster();
		    	 
		    	 if(!przyciskMieszanie.isEnabled()){
		    		 przyciskMieszanie.setEnabled(true);
		    	 }
		     }
		});
		
		przyciskWyniki.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 usunieciePaneluMenu();
		    	 dodaniePaneluWynikow();
		    	 czyszczeniePanelu();
		     }
		});
		
		przyciskScorePowrot.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 usunieciePaneluWynikow();
		    	 dodaniePaneluMenu();
		    	 czyszczeniePanelu();
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
		    	 panelKart.usuwanieKartZPanelu();
		    	 powrotDoMenu();
		    	 if(timer2.isRunning()){
		    		 timer2.stop();
		    	 }
		    	 panelKart.wyzerowanieZnalezionychPar(0);
		    	 panelKart.resetowanieLiczbyProb(0);
		    	 stoper.resetStoper();
		     }
		});
		
		przyciskMieszanie.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 panelKart.dodawanieKartDoPanelu();
		    	 stoper.startCzas();
		    	 przyciskMieszanie.zamrozeniePrzycisku();
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
	
	public void removeStart(){
		usunieciePrzyciskuStart();
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
		
		public void dodaniePaneluWynikow(){
			add(panelWynikow);
		}
		
		public void usunieciePaneluWynikow(){
			remove(panelWynikow);
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
		    	 przyciskMieszanie.odmrozeniePrzycisku();	 
	    	 }
		}
		
		public String wartoscPunktowDoString(){
			return String.valueOf(obliczWynikKoncowy());
		}
		
		public int obliczWynikKoncowy(){
			return (int) (score = (stoper.pobierzCzasKtoryUplynal() * panelKart.getLiczbaProb()));
		}
		
		public void usunieciePrzyciskuStart(){
			panelMenu.remove(przyciskStart);
		}
		
		public void operacjeNaOkienku(){
			if (tekst == null){
			}
			else{
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter("src\\MemoryMasterPakiet\\wyniki.txt", true));
					writer.newLine();
					writer.write(stringOstateczny());
					writer.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
		public String stringOstateczny(){
			return stringOstateczny =(ustawienieStringaDoTextu()+ " " + tekst);
		}
		
		public String ustawienieStringaDoTextu(){
			return stringToTXT = String.valueOf(obliczWynikKoncowy());
		}
}
