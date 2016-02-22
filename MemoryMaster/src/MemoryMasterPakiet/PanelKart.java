package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelKart extends JPanel implements Runnable, ActionListener{
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    
    final private int szerokoscRamki = screenSize.width;
    final private int wysokoscRamki = screenSize.height;
    final private double szerokoscPaneluKartDouble = szerokoscRamki * 0.79;
    final private int szerokoscPaneluKartInteger = (int) szerokoscPaneluKartDouble;
    final private double odstepPionowyDouble = wysokoscRamki * 0.005;
    final private int odstepPionowyInteger = (int) odstepPionowyDouble;
    final private double odstepPoziomyDouble = szerokoscRamki * 0.005;
    final private int odstepPoziomyInteger = (int) odstepPoziomyDouble;
    
    private int liczbaKlikniec = 0;
    private boolean wartoscSluchacza = true;
    private int liczbaWybranychKart = 0;
    private int liczbaZnalezionychPar = 48;
    
    KartaPierwsza kartaPierwsza = new KartaPierwsza();
    KartaPierwsza kartaPierwszaBis = new KartaPierwsza();
    KartaDruga kartaDruga = new KartaDruga();
    KartaTrzecia kartaTrzecia = new KartaTrzecia();
    KartaCzwarta kartaCzwarta = new KartaCzwarta();
    KartaPiata kartaPiata = new KartaPiata();
	KartaSzosta kartaSzosta = new KartaSzosta();
	KartaSiodma kartaSiodma = new KartaSiodma();
	KartaOsma kartaOsma = new KartaOsma();
	KartaDziewiata kartaDziewiata = new KartaDziewiata();
	KartaDziesiata kartaDziesiata = new KartaDziesiata();
	KartaJedenasta kartaJedenasta = new KartaJedenasta();
	KartaDwunasta kartaDwunasta = new KartaDwunasta();
	KartaTrzynasta kartaTrzynasta = new KartaTrzynasta();
	
	ArrayList<KartaGlowna> zbiorKart = new ArrayList<KartaGlowna>(48);
	
	Thread watek = new Thread(this);
	
	JButton klon1 = new JButton();
	JButton klon2 = new JButton();
    
	public PanelKart(){
		setPreferredSize(new Dimension(szerokoscPaneluKartInteger, wysokoscRamki));
		setLayout(new GridLayout(6,8, odstepPoziomyInteger, odstepPionowyInteger));
		setBackground(Color.WHITE);
		dodanieKartDoZbioru();
		
		watek.start();
	}
	
	public void dodawanieKartDoPanelu(){
		wymieszaniePozycjiKart();
		wybieranieOrazUstawianieKart();
		dodanieSluchaczy();
		odmalowaniePanelu();
	}
	
	public void usuwanieKartZPanelu(){
		uswanieKart();
		rewalidacja();
	}
	
		public void dodanieKartDoZbioru(){
			zbiorKart.add(kartaPierwsza);
			zbiorKart.add(kartaPierwszaBis);
			zbiorKart.add(kartaDruga);
			zbiorKart.add(kartaTrzecia);
			zbiorKart.add(kartaCzwarta);
			zbiorKart.add(kartaPiata);
			zbiorKart.add(kartaSzosta);
			zbiorKart.add(kartaSiodma);
			zbiorKart.add(kartaOsma);
			zbiorKart.add(kartaDziewiata);
			zbiorKart.add(kartaDziesiata);
			zbiorKart.add(kartaJedenasta);
			zbiorKart.add(kartaDwunasta);
			zbiorKart.add(kartaTrzynasta);
		}
	
		public void wymieszaniePozycjiKart(){
		Collections.shuffle(zbiorKart);
		}
	
		public void wybieranieOrazUstawianieKart(){
			for(int i = 0; i < zbiorKart.size(); i++){
				this.add(zbiorKart.get(i));
			}
		}
		
		public void dodanieSluchaczy(){
			if(wartoscSluchacza == true){
				wartoscSluchacza = false;
			for(int i = 0; i < zbiorKart.size(); i++){
				zbiorKart.get(i).addActionListener(this);
			}
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == kartaPierwsza){
				akcjaKartaPierwsza();
			}
			
			if(e.getSource() == kartaPierwszaBis){
				akcjaKartaPierwszaBis();
			}
		}
		
		public void run(){
			while(true){
				uspienieWatku();
				porownaniePierwszychKart();
				
				}	
		}	
		
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
				public void uswanieKart(){
					this.removeAll();
					}
			
				public void odmalowaniePanelu(){
					rewalidacja();
					odmalowanie();
				}
			
				public void rewalidacja(){
					this.revalidate();
				}
			
				public void odmalowanie(){
					this.repaint();
				}
			
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				
				public void porownaniePierwszychKart(){
					if(ustawieniaKartaPierwsza() == false && ustawieniaKartaPierwszaBis() == false && pobranieUstawienieWybranejPary() == true){
						uspienieWatku();
						kartaPierwsza.zablokowanieKarty();
						kartaPierwszaBis.zablokowanieKarty();
						ustawienieWybranejPary();
						setLiczbaZnalezionychPar();
						System.out.println(liczbaZnalezionychPar);
					}
				}
				
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++				
					public void akcjaKartaPierwsza(){
						dodanieKlikniecia();
						setLiczbaWybranychKart();
						kartaPierwsza.wyborTejKarty();
					}
					
					public boolean ustawieniaKartaPierwsza(){
						return kartaPierwsza.getStanKarty();
					}
					
					public void akcjaKartaPierwszaBis(){
						dodanieKlikniecia();
						setLiczbaWybranychKart();
						kartaPierwszaBis.wyborTejKarty();
					}
					
					public boolean ustawieniaKartaPierwszaBis(){
						return kartaPierwszaBis.getStanKarty();
					}
					
					public void ustawienieWybranejPary(){
						kartaPierwsza.setWybranaPara(false);
					}
					
					public boolean pobranieUstawienieWybranejPary(){
						return kartaPierwsza.getWybranaPara();
					}
					
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++					
						public int getLiczbaKlikniec(){
							return liczbaKlikniec;
						}
						
						public void dodanieKlikniecia(){
							liczbaKlikniec++;
						}
						
						public void resetowanieLiczbyKlikniec(int liczbaKlikniec){
							this.liczbaKlikniec = liczbaKlikniec;
						}
						
						public void setLiczbaWybranychKart(){
							liczbaWybranychKart++;
						}
						
						public int getLiczbaWybranychKart(){
							return liczbaWybranychKart;
						}
						
						public void setLiczbaZnalezionychPar(){
							liczbaZnalezionychPar--;
						}
						
						public void uspienieWatku(){
							try {
						        Thread.sleep(1);
						    } catch (InterruptedException ignore) {
						    }
						}
	}
