package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
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
    private int liczbaZnalezionychPar = 48;
    private boolean wartoscKlonu1 = false;
    private boolean wartoscKlonu2 = false;
    
    KartaPodstawowa klon1 = new KartaPodstawowa();
    KartaPodstawowa klon2 = new KartaPodstawowa();
    KartaPodstawowa kartaPierwsza = new KartaPodstawowa();
    KartaPodstawowa kartaPierwszaBis = new KartaPodstawowa();
    KartaPodstawowa kartaDruga = new KartaPodstawowa();
    KartaPodstawowa kartaDrugaBis = new KartaPodstawowa();
    KartaPodstawowa kartaTrzecia = new KartaPodstawowa();
    KartaPodstawowa kartaCzwarta = new KartaPodstawowa();
    KartaPodstawowa kartaPiata = new KartaPodstawowa();
    KartaPodstawowa kartaSzosta = new KartaPodstawowa();
    KartaPodstawowa kartaSiodma = new KartaPodstawowa();
    KartaPodstawowa kartaOsma = new KartaPodstawowa();
    KartaPodstawowa kartaDziewiata = new KartaPodstawowa();
    KartaPodstawowa kartaDziesiata = new KartaPodstawowa();
    KartaPodstawowa kartaJedenasta = new KartaPodstawowa();
    KartaPodstawowa kartaDwunasta = new KartaPodstawowa();
    KartaPodstawowa kartaTrzynasta = new KartaPodstawowa();
	
	ArrayList<KartaGlowna> zbiorKart = new ArrayList<KartaGlowna>(48);
	
	Thread watek = new Thread(this);
	  
	public PanelKart(){
		setPreferredSize(new Dimension(szerokoscPaneluKartInteger, wysokoscRamki));
		setLayout(new GridLayout(6,8, odstepPoziomyInteger, odstepPionowyInteger));
		setBackground(Color.WHITE);
		dodanieKartDoZbioru();
		dodanieSluchaczy();
		
		watek.start();
	}
	
	public void dodawanieKartDoPanelu(){
		wymieszaniePozycjiKart();
		wybieranieOrazUstawianieKart();
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
			zbiorKart.add(kartaDrugaBis);
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
				wyzerowanieZnalezionychPar(48);
				(zbiorKart.get(i)).setEnabled(true);
				(zbiorKart.get(i)).setBackground(new Color(75, 181, 48));
				(zbiorKart.get(i)).setText("");
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
				klonowanieKartyPierwszej();
			}
			
			if(e.getSource() == kartaPierwszaBis){
				klonowanieKartyPierwszejBis();
			}
			
			if(e.getSource() == kartaDruga){
				klonowanieKartyDrugiej();
			}
			if(e.getSource() == kartaDrugaBis){
				klonowanieKartyDrugiejBis();
			}
		}
		
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void klonowanieKartyPierwszej(){
				if(wartoscKlonu1 == false){
					kartaPierwsza.ustawTekst("1");
					kartaPierwsza.ustawNumerKarty(1);
					wartoscKlonu1 = true;
					klon1 = kartaPierwsza;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaPierwsza.ustawTekst("1");
					kartaPierwsza.ustawNumerKarty(1);
					wartoscKlonu2 = true;
					klon2 = kartaPierwsza;
					akcjaKlon2();
				}
			}	
			
			public void klonowanieKartyPierwszejBis(){
				if(wartoscKlonu1 == false){
					kartaPierwszaBis.ustawTekst("1");
					kartaPierwszaBis.ustawNumerKarty(1);
					wartoscKlonu1 = true;
					klon1 = kartaPierwszaBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaPierwszaBis.ustawTekst("1");
					kartaPierwszaBis.ustawNumerKarty(1);
					wartoscKlonu2 = true;
					klon2 = kartaPierwszaBis;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyDrugiej(){
				if(wartoscKlonu1 == false){
					kartaDruga.ustawTekst("2");
					kartaDruga.ustawNumerKarty(2);
					wartoscKlonu1 = true;
					klon1 = kartaDruga;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaDruga.ustawTekst("2");
					kartaDruga.ustawNumerKarty(2);
					wartoscKlonu2 = true;
					klon2 = kartaDruga;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyDrugiejBis(){
				if(wartoscKlonu1 == false){
					kartaDrugaBis.ustawTekst("2");
					kartaDrugaBis.ustawNumerKarty(2);
					wartoscKlonu1 = true;
					klon1 = kartaDrugaBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaDrugaBis.ustawTekst("2");
					kartaDrugaBis.ustawNumerKarty(2);
					wartoscKlonu2 = true;
					klon2 = kartaDrugaBis;
					akcjaKlon2();
				}
			}
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void run(){
				while(true){
					uspienieWatku1();
					porownanieKartKlonow();
					}	
			}
		
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				public void porownanieKartKlonow(){
					if(ustawieniaKlon1() == ustawieniaKlon2() && wartoscKlonu1 == true && wartoscKlonu2 == true){
						wartoscKlonu1 = false;
						wartoscKlonu2 = false;
						klon1.zablokowanieKarty();
						klon2.zablokowanieKarty();
						klon1.ustawNumerKarty(100);
						klon2.ustawNumerKarty(101);
						dodanieKlikniecia();
						dodanieKlikniecia();
						setLiczbaZnalezionychPar();
					}
					
					 else if(ustawieniaKlon1() != ustawieniaKlon2() && wartoscKlonu1 == true && wartoscKlonu2 == true){
						uspienieWatku2();
						wartoscKlonu1 = false;
						wartoscKlonu2 = false;
						klon1.ustawTekst("");
						klon2.ustawTekst("");
						klon1.ustawZieloneTlo();
						klon2.ustawZieloneTlo();
						klon1.odblokowanieKarty();
						klon2.odblokowanieKarty();
						dodanieKlikniecia();
						dodanieKlikniecia();
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
						
							public void akcjaKlon1(){
								klon1.wyborTejKarty();
							}
							
							public int ustawieniaKlon1(){
								return klon1.getNumerKarty();
							}
							
							public void akcjaKlon2(){
								klon2.wyborTejKarty();
							}
							
							public int ustawieniaKlon2(){
								return klon2.getNumerKarty();
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
								
								public void setLiczbaZnalezionychPar(){
									liczbaZnalezionychPar--;
								}
								
								public void wyzerowanieZnalezionychPar(int liczbaZnalezionychPar){
									this.liczbaZnalezionychPar = liczbaZnalezionychPar;
								}
								
								public int getLiczbaZnalezionychPar(){
									return liczbaZnalezionychPar;
								}
								
								public void setWartoscKlonu1(boolean wartoscKlonu1){
									this.wartoscKlonu1 = wartoscKlonu1;
								}
								
								public boolean getWartoscKlonu1(){
									return wartoscKlonu1;
								}
								
								public void setWartoscKlonu2(boolean wartoscKlonu2){
									this.wartoscKlonu2 = wartoscKlonu2;
								}
								
								public boolean getWartoscKlonu2(){
									return wartoscKlonu2;
								}
								
								public void uspienieWatku1(){
									try {
								        Thread.sleep(1);
								    } catch (InterruptedException ignore) {
								    }
								}
								
								public void uspienieWatku2(){
									try {
								        Thread.sleep(750);
								    } catch (InterruptedException ignore) {
								    }
								}
	}
