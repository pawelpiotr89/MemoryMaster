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
    
    private int liczbaProb = 0;
    private boolean wartoscSluchacza = true;
    private int liczbaZnalezionychPar = 0;
    private boolean wartoscKlonu1 = false;
    private boolean wartoscKlonu2 = false;
    private boolean koniecGry  = false;
    
    KartaPodstawowa klon1 = new KartaPodstawowa();
    KartaPodstawowa klon2 = new KartaPodstawowa();
    KartaPodstawowa kartaPierwsza = new KartaPodstawowa();
    KartaPodstawowa kartaPierwszaBis = new KartaPodstawowa();
    KartaPodstawowa kartaDruga = new KartaPodstawowa();
    KartaPodstawowa kartaDrugaBis = new KartaPodstawowa();
    KartaPodstawowa kartaTrzecia = new KartaPodstawowa();
    KartaPodstawowa kartaTrzeciaBis = new KartaPodstawowa();
    KartaPodstawowa kartaCzwarta = new KartaPodstawowa();
    KartaPodstawowa kartaCzwartaBis = new KartaPodstawowa();
    KartaPodstawowa kartaPiata = new KartaPodstawowa();
    KartaPodstawowa kartaPiataBis = new KartaPodstawowa();
    KartaPodstawowa kartaSzosta = new KartaPodstawowa();
    KartaPodstawowa kartaSzostaBis = new KartaPodstawowa();
    KartaPodstawowa kartaSiodma = new KartaPodstawowa();
    KartaPodstawowa kartaSiodmaBis = new KartaPodstawowa();
    KartaPodstawowa kartaOsma = new KartaPodstawowa();
    KartaPodstawowa kartaOsmaBis = new KartaPodstawowa();
    KartaPodstawowa kartaDziewiata = new KartaPodstawowa();
    KartaPodstawowa kartaDziewiataBis = new KartaPodstawowa();
    KartaPodstawowa kartaDziesiata = new KartaPodstawowa();
    KartaPodstawowa kartaDziesiataBis = new KartaPodstawowa();
    KartaPodstawowa kartaJedenasta = new KartaPodstawowa();
    KartaPodstawowa kartaJedenastaBis = new KartaPodstawowa();
    KartaPodstawowa kartaDwunasta = new KartaPodstawowa();
    KartaPodstawowa kartaDwunastaBis = new KartaPodstawowa();
    KartaPodstawowa kartaTrzynasta = new KartaPodstawowa();
    KartaPodstawowa kartaTrzynastaBis = new KartaPodstawowa();
    KartaPodstawowa kartaCzternasta = new KartaPodstawowa();
    KartaPodstawowa kartaCzternastaBis = new KartaPodstawowa();
    KartaPodstawowa kartaPietnasta = new KartaPodstawowa();
    KartaPodstawowa kartaPietnastaBis = new KartaPodstawowa();
    KartaPodstawowa kartaSzesnasta = new KartaPodstawowa();
    KartaPodstawowa kartaSzesnastaBis = new KartaPodstawowa();
    KartaPodstawowa kartaSiedemnasta = new KartaPodstawowa();
    KartaPodstawowa kartaSiedemnastaBis = new KartaPodstawowa();
    KartaPodstawowa kartaOsiemnasta = new KartaPodstawowa();
    KartaPodstawowa kartaOsiemnastaBis = new KartaPodstawowa();
    KartaPodstawowa kartaDziewietnasta = new KartaPodstawowa();
    KartaPodstawowa kartaDziewietnastaBis = new KartaPodstawowa();
    KartaPodstawowa kartaDwudziesta = new KartaPodstawowa();
    KartaPodstawowa kartaDwudziestaBis = new KartaPodstawowa();
    KartaPodstawowa kartaDwudziestaPierwsza = new KartaPodstawowa();
    KartaPodstawowa kartaDwudziestaPierwszaBis = new KartaPodstawowa();
    
	
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
			zbiorKart.add(kartaTrzeciaBis);
			zbiorKart.add(kartaCzwarta);
			zbiorKart.add(kartaCzwartaBis);
			zbiorKart.add(kartaPiata);
			zbiorKart.add(kartaPiataBis);
			zbiorKart.add(kartaSzosta);
			zbiorKart.add(kartaSzostaBis);
			zbiorKart.add(kartaSiodma);
			zbiorKart.add(kartaSiodmaBis);
			zbiorKart.add(kartaOsma);
			zbiorKart.add(kartaOsmaBis);
			zbiorKart.add(kartaDziewiata);
			zbiorKart.add(kartaDziewiataBis);
			zbiorKart.add(kartaDziesiata);
			zbiorKart.add(kartaDziesiataBis);
			zbiorKart.add(kartaJedenasta);
			zbiorKart.add(kartaJedenastaBis);
			zbiorKart.add(kartaDwunasta);
			zbiorKart.add(kartaDwunastaBis);
			zbiorKart.add(kartaTrzynasta);
			zbiorKart.add(kartaTrzynastaBis);
			zbiorKart.add(kartaCzternasta);
			zbiorKart.add(kartaCzternastaBis);
			zbiorKart.add(kartaPietnasta);
			zbiorKart.add(kartaPietnastaBis);
			zbiorKart.add(kartaSzesnasta);
			zbiorKart.add(kartaSzesnastaBis);
			zbiorKart.add(kartaSiedemnasta);
			zbiorKart.add(kartaSiedemnastaBis);
			zbiorKart.add(kartaOsiemnasta);
			zbiorKart.add(kartaOsiemnastaBis);
			zbiorKart.add(kartaDziewietnasta);
			zbiorKart.add(kartaDziewietnastaBis);
			zbiorKart.add(kartaDwudziesta);
			zbiorKart.add(kartaDwudziestaBis);
			zbiorKart.add(kartaDwudziestaPierwsza);
			zbiorKart.add(kartaDwudziestaPierwszaBis);
		}
	
		public void wymieszaniePozycjiKart(){
		Collections.shuffle(zbiorKart);
		}
	
		public void wybieranieOrazUstawianieKart(){
			for(int i = 0; i < zbiorKart.size(); i++){
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
			
			if(e.getSource() == kartaTrzecia){
				klonowanieKartyTrzeciej();
			}
			
			if(e.getSource() == kartaTrzeciaBis){
				klonowanieKartyTrzeciejBis();
			}
			
			if(e.getSource() == kartaCzwarta){
				klonowanieKartyCzwartej();
			}
			
			if(e.getSource() == kartaCzwartaBis){
				klonowanieKartyCzwartejBis();
			}
			
			if(e.getSource() == kartaPiata){
				klonowanieKartyPiatej();
			}
			
			if(e.getSource() == kartaPiataBis){
				klonowanieKartyPiatejBis();
			}
			
			if(e.getSource() == kartaSzosta){
				klonowanieKartySzostej();
			}
			
			if(e.getSource() == kartaSzostaBis){
				klonowanieKartySzostejBis();
			}
			
			if(e.getSource() == kartaSiodma){
				klonowanieKartySiodmej();
			}
			
			if(e.getSource() == kartaSiodmaBis){
				klonowanieKartySiodmejBis();
			}
			
			if(e.getSource() == kartaOsma){
				klonowanieKartyOsmej();
			}
			
			if(e.getSource() == kartaOsmaBis){
				klonowanieKartyOsmejBis();
			}
			
			if(e.getSource() == kartaDziewiata){
				klonowanieKartyDziewiatej();
			}
			
			if(e.getSource() == kartaDziewiataBis){
				klonowanieKartyDziewiatejBis();
			}
			
			if(e.getSource() == kartaDziesiata){
				klonowanieKartyDziesiatej();
			}
			
			if(e.getSource() == kartaDziesiataBis){
				klonowanieKartyDziesiatejBis();
			}
			
			if(e.getSource() == kartaJedenasta){
				klonowanieKartyJedenastej();
			}
			
			if(e.getSource() == kartaJedenastaBis){
				klonowanieKartyJedenastejBis();
			}
			
			if(e.getSource() == kartaDwunasta){
				klonowanieKartyDwunastej();
			}
			
			if(e.getSource() == kartaDwunastaBis){
				klonowanieKartyDwunastejBis();
			}
			
			if(e.getSource() == kartaTrzynasta){
				klonowanieKartyTrzynastej();
			}
			
			if(e.getSource() == kartaTrzynastaBis){
				klonowanieKartyTrzynastejBis();
			}
			
			if(e.getSource() == kartaCzternasta){
				klonowanieKartyCzternastej();
			}
			
			if(e.getSource() == kartaCzternastaBis){
				klonowanieKartyCzternastejBis();
			}
			
			if(e.getSource() == kartaPietnasta){
				klonowanieKartyPietnastej();
			}
			
			if(e.getSource() == kartaPietnastaBis){
				klonowanieKartyPietnastejBis();
			}
			
			if(e.getSource() == kartaSzesnasta){
				klonowanieKartySzesnastej();
			}
			
			if(e.getSource() == kartaSzesnastaBis){
				klonowanieKartySzesnastejBis();
			}
			
			if(e.getSource() == kartaSiedemnasta){
				klonowanieKartySiedemnastej();
			}
			
			if(e.getSource() == kartaSiedemnastaBis){
				klonowanieKartySiedemnastejBis();
			}
			
			if(e.getSource() == kartaOsiemnasta){
				klonowanieKartyOsiemnastej();
			}
			
			if(e.getSource() == kartaOsiemnastaBis){
				klonowanieKartyOsiemnastejBis();
			}
			
			if(e.getSource() == kartaDziewietnasta){
				klonowanieKartyDziewietnastej();
			}
			
			if(e.getSource() == kartaDziewietnastaBis){
				klonowanieKartyDziewietnastejBis();
			}
			
			if(e.getSource() == kartaDwudziesta){
				klonowanieKartyDwudziestej();
			}
			
			if(e.getSource() == kartaDwudziestaBis){
				klonowanieKartyDwudziestejBis();
			}
			
			if(e.getSource() == kartaDwudziestaPierwsza){
				klonowanieKartyDwudziestejPierwszej();
			}
			
			if(e.getSource() == kartaDwudziestaPierwszaBis){
				klonowanieKartyDwudziestejPierwszejBis();
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
			
			public void klonowanieKartyTrzeciej(){
				if(wartoscKlonu1 == false){
					kartaTrzecia.ustawTekst("3");
					kartaTrzecia.ustawNumerKarty(3);
					wartoscKlonu1 = true;
					klon1 = kartaTrzecia;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaTrzecia.ustawTekst("3");
					kartaTrzecia.ustawNumerKarty(3);
					wartoscKlonu2 = true;
					klon2 = kartaTrzecia;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyTrzeciejBis(){
				if(wartoscKlonu1 == false){
					kartaTrzeciaBis.ustawTekst("3");
					kartaTrzeciaBis.ustawNumerKarty(3);
					wartoscKlonu1 = true;
					klon1 = kartaTrzeciaBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaTrzeciaBis.ustawTekst("3");
					kartaTrzeciaBis.ustawNumerKarty(3);
					wartoscKlonu2 = true;
					klon2 = kartaTrzeciaBis;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyCzwartej(){
				if(wartoscKlonu1 == false){
					kartaCzwarta.ustawTekst("4");
					kartaCzwarta.ustawNumerKarty(4);
					wartoscKlonu1 = true;
					klon1 = kartaCzwarta;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaCzwarta.ustawTekst("4");
					kartaCzwarta.ustawNumerKarty(4);
					wartoscKlonu2 = true;
					klon2 = kartaCzwarta;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyCzwartejBis(){
				if(wartoscKlonu1 == false){
					kartaCzwartaBis.ustawTekst("4");
					kartaCzwartaBis.ustawNumerKarty(4);
					wartoscKlonu1 = true;
					klon1 = kartaCzwartaBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaCzwartaBis.ustawTekst("4");
					kartaCzwartaBis.ustawNumerKarty(4);
					wartoscKlonu2 = true;
					klon2 = kartaCzwartaBis;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyPiatej(){
				if(wartoscKlonu1 == false){
					kartaPiata.ustawTekst("5");
					kartaPiata.ustawNumerKarty(5);
					wartoscKlonu1 = true;
					klon1 = kartaPiata;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaPiata.ustawTekst("5");
					kartaPiata.ustawNumerKarty(5);
					wartoscKlonu2 = true;
					klon2 = kartaPiata;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyPiatejBis(){
				if(wartoscKlonu1 == false){
					kartaPiataBis.ustawTekst("5");
					kartaPiataBis.ustawNumerKarty(5);
					wartoscKlonu1 = true;
					klon1 = kartaPiataBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaPiataBis.ustawTekst("5");
					kartaPiataBis.ustawNumerKarty(5);
					wartoscKlonu2 = true;
					klon2 = kartaPiataBis;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartySzostej(){
				if(wartoscKlonu1 == false){
					kartaSzosta.ustawTekst("6");
					kartaSzosta.ustawNumerKarty(6);
					wartoscKlonu1 = true;
					klon1 = kartaSzosta;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaSzosta.ustawTekst("6");
					kartaSzosta.ustawNumerKarty(6);
					wartoscKlonu2 = true;
					klon2 = kartaSzosta;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartySzostejBis(){
				if(wartoscKlonu1 == false){
					kartaSzostaBis.ustawTekst("6");
					kartaSzostaBis.ustawNumerKarty(6);
					wartoscKlonu1 = true;
					klon1 = kartaSzostaBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaSzostaBis.ustawTekst("6");
					kartaSzostaBis.ustawNumerKarty(6);
					wartoscKlonu2 = true;
					klon2 = kartaSzostaBis;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartySiodmej(){
				if(wartoscKlonu1 == false){
					kartaSiodma.ustawTekst("7");
					kartaSiodma.ustawNumerKarty(7);
					wartoscKlonu1 = true;
					klon1 = kartaSiodma;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaSiodma.ustawTekst("7");
					kartaSiodma.ustawNumerKarty(7);
					wartoscKlonu2 = true;
					klon2 = kartaSiodma;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartySiodmejBis(){
				if(wartoscKlonu1 == false){
					kartaSiodmaBis.ustawTekst("7");
					kartaSiodmaBis.ustawNumerKarty(7);
					wartoscKlonu1 = true;
					klon1 = kartaSiodmaBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaSiodmaBis.ustawTekst("7");
					kartaSiodmaBis.ustawNumerKarty(7);
					wartoscKlonu2 = true;
					klon2 = kartaSiodmaBis;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyOsmej(){
				if(wartoscKlonu1 == false){
					kartaOsma.ustawTekst("8");
					kartaOsma.ustawNumerKarty(8);
					wartoscKlonu1 = true;
					klon1 = kartaOsma;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaOsma.ustawTekst("8");
					kartaOsma.ustawNumerKarty(8);
					wartoscKlonu2 = true;
					klon2 = kartaOsma;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyOsmejBis(){
				if(wartoscKlonu1 == false){
					kartaOsmaBis.ustawTekst("8");
					kartaOsmaBis.ustawNumerKarty(8);
					wartoscKlonu1 = true;
					klon1 = kartaOsmaBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaOsmaBis.ustawTekst("8");
					kartaOsmaBis.ustawNumerKarty(8);
					wartoscKlonu2 = true;
					klon2 = kartaOsmaBis;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyDziewiatej(){
				if(wartoscKlonu1 == false){
					kartaDziewiata.ustawTekst("9");
					kartaDziewiata.ustawNumerKarty(9);
					wartoscKlonu1 = true;
					klon1 = kartaDziewiata;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaDziewiata.ustawTekst("9");
					kartaDziewiata.ustawNumerKarty(9);
					wartoscKlonu2 = true;
					klon2 = kartaDziewiata;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyDziewiatejBis(){
				if(wartoscKlonu1 == false){
					kartaDziewiataBis.ustawTekst("9");
					kartaDziewiataBis.ustawNumerKarty(9);
					wartoscKlonu1 = true;
					klon1 = kartaDziewiataBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaDziewiataBis.ustawTekst("9");
					kartaDziewiataBis.ustawNumerKarty(9);
					wartoscKlonu2 = true;
					klon2 = kartaDziewiataBis;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyDziesiatej(){
				if(wartoscKlonu1 == false){
					kartaDziesiata.ustawTekst("10");
					kartaDziesiata.ustawNumerKarty(10);
					wartoscKlonu1 = true;
					klon1 = kartaDziesiata;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaDziesiata.ustawTekst("10");
					kartaDziesiata.ustawNumerKarty(10);
					wartoscKlonu2 = true;
					klon2 = kartaDziesiata;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyDziesiatejBis(){
				if(wartoscKlonu1 == false){
					kartaDziesiataBis.ustawTekst("10");
					kartaDziesiataBis.ustawNumerKarty(10);
					wartoscKlonu1 = true;
					klon1 = kartaDziesiataBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaDziesiataBis.ustawTekst("10");
					kartaDziesiataBis.ustawNumerKarty(10);
					wartoscKlonu2 = true;
					klon2 = kartaDziesiataBis;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyJedenastej(){
				if(wartoscKlonu1 == false){
					kartaJedenasta.ustawTekst("11");
					kartaJedenasta.ustawNumerKarty(11);
					wartoscKlonu1 = true;
					klon1 = kartaJedenasta;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaJedenasta.ustawTekst("11");
					kartaJedenasta.ustawNumerKarty(11);
					wartoscKlonu2 = true;
					klon2 = kartaJedenasta;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyJedenastejBis(){
				if(wartoscKlonu1 == false){
					kartaJedenastaBis.ustawTekst("11");
					kartaJedenastaBis.ustawNumerKarty(11);
					wartoscKlonu1 = true;
					klon1 = kartaJedenastaBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaJedenastaBis.ustawTekst("11");
					kartaJedenastaBis.ustawNumerKarty(11);
					wartoscKlonu2 = true;
					klon2 = kartaJedenastaBis;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyDwunastej(){
				if(wartoscKlonu1 == false){
					kartaDwunasta.ustawTekst("12");
					kartaDwunasta.ustawNumerKarty(12);
					wartoscKlonu1 = true;
					klon1 = kartaDwunasta;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaDwunasta.ustawTekst("12");
					kartaDwunasta.ustawNumerKarty(12);
					wartoscKlonu2 = true;
					klon2 = kartaDwunasta;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyDwunastejBis(){
				if(wartoscKlonu1 == false){
					kartaDwunastaBis.ustawTekst("12");
					kartaDwunastaBis.ustawNumerKarty(12);
					wartoscKlonu1 = true;
					klon1 = kartaDwunastaBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaDwunastaBis.ustawTekst("12");
					kartaDwunastaBis.ustawNumerKarty(12);
					wartoscKlonu2 = true;
					klon2 = kartaDwunastaBis;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyTrzynastej(){
				if(wartoscKlonu1 == false){
					kartaTrzynasta.ustawTekst("13");
					kartaTrzynasta.ustawNumerKarty(13);
					wartoscKlonu1 = true;
					klon1 = kartaTrzynasta;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaTrzynasta.ustawTekst("13");
					kartaTrzynasta.ustawNumerKarty(13);
					wartoscKlonu2 = true;
					klon2 = kartaTrzynasta;
					akcjaKlon2();
				}
			}
			
			public void klonowanieKartyTrzynastejBis(){
				if(wartoscKlonu1 == false){
					kartaTrzynastaBis.ustawTekst("13");
					kartaTrzynastaBis.ustawNumerKarty(13);
					wartoscKlonu1 = true;
					klon1 = kartaTrzynastaBis;
					akcjaKlon1();
				}
				else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
					kartaTrzynastaBis.ustawTekst("13");
					kartaTrzynastaBis.ustawNumerKarty(13);
					wartoscKlonu2 = true;
					klon2 = kartaTrzynastaBis;
					akcjaKlon2();
				}
			}
				
				public void klonowanieKartyCzternastej(){
					if(wartoscKlonu1 == false){
						kartaCzternasta.ustawTekst("14");
						kartaCzternasta.ustawNumerKarty(14);
						wartoscKlonu1 = true;
						klon1 = kartaCzternasta;
						akcjaKlon1();
					}
					else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
						kartaCzternasta.ustawTekst("14");
						kartaCzternasta.ustawNumerKarty(14);
						wartoscKlonu2 = true;
						klon2 = kartaCzternasta;
						akcjaKlon2();
					}
				}
				
				public void klonowanieKartyCzternastejBis(){
					if(wartoscKlonu1 == false){
						kartaCzternastaBis.ustawTekst("14");
						kartaCzternastaBis.ustawNumerKarty(14);
						wartoscKlonu1 = true;
						klon1 = kartaCzternastaBis;
						akcjaKlon1();
					}
					else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
						kartaCzternastaBis.ustawTekst("14");
						kartaCzternastaBis.ustawNumerKarty(14);
						wartoscKlonu2 = true;
						klon2 = kartaCzternastaBis;
						akcjaKlon2();
					}
				}
					
					public void klonowanieKartyPietnastej(){
						if(wartoscKlonu1 == false){
							kartaPietnasta.ustawTekst("15");
							kartaPietnasta.ustawNumerKarty(15);
							wartoscKlonu1 = true;
							klon1 = kartaPietnasta;
							akcjaKlon1();
						}
						else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
							kartaPietnasta.ustawTekst("15");
							kartaPietnasta.ustawNumerKarty(15);
							wartoscKlonu2 = true;
							klon2 = kartaPietnasta;
							akcjaKlon2();
						}
					}
					
					public void klonowanieKartyPietnastejBis(){
						if(wartoscKlonu1 == false){
							kartaPietnastaBis.ustawTekst("15");
							kartaPietnastaBis.ustawNumerKarty(15);
							wartoscKlonu1 = true;
							klon1 = kartaPietnastaBis;
							akcjaKlon1();
						}
						else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
							kartaPietnastaBis.ustawTekst("15");
							kartaPietnastaBis.ustawNumerKarty(15);
							wartoscKlonu2 = true;
							klon2 = kartaPietnastaBis;
							akcjaKlon2();
						}
					}
						
						public void klonowanieKartySzesnastej(){
							if(wartoscKlonu1 == false){
								kartaSzesnasta.ustawTekst("16");
								kartaSzesnasta.ustawNumerKarty(16);
								wartoscKlonu1 = true;
								klon1 = kartaSzesnasta;
								akcjaKlon1();
							}
							else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
								kartaSzesnasta.ustawTekst("16");
								kartaSzesnasta.ustawNumerKarty(16);
								wartoscKlonu2 = true;
								klon2 = kartaSzesnasta;
								akcjaKlon2();
							}
						}
						
						public void klonowanieKartySzesnastejBis(){
							if(wartoscKlonu1 == false){
								kartaSzesnastaBis.ustawTekst("16");
								kartaSzesnastaBis.ustawNumerKarty(16);
								wartoscKlonu1 = true;
								klon1 = kartaSzesnastaBis;
								akcjaKlon1();
							}
							else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
								kartaSzesnastaBis.ustawTekst("16");
								kartaSzesnastaBis.ustawNumerKarty(16);
								wartoscKlonu2 = true;
								klon2 = kartaSzesnastaBis;
								akcjaKlon2();
							}
						}
						
						public void klonowanieKartySiedemnastej(){
							if(wartoscKlonu1 == false){
								kartaSiedemnasta.ustawTekst("17");
								kartaSiedemnasta.ustawNumerKarty(17);
								wartoscKlonu1 = true;
								klon1 = kartaSiedemnasta;
								akcjaKlon1();
							}
							else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
								kartaSiedemnasta.ustawTekst("17");
								kartaSiedemnasta.ustawNumerKarty(17);
								wartoscKlonu2 = true;
								klon2 = kartaSiedemnasta;
								akcjaKlon2();
							}
						}
						
						public void klonowanieKartySiedemnastejBis(){
							if(wartoscKlonu1 == false){
								kartaSiedemnastaBis.ustawTekst("17");
								kartaSiedemnastaBis.ustawNumerKarty(17);
								wartoscKlonu1 = true;
								klon1 = kartaSiedemnastaBis;
								akcjaKlon1();
							}
							else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
								kartaSiedemnastaBis.ustawTekst("17");
								kartaSiedemnastaBis.ustawNumerKarty(17);
								wartoscKlonu2 = true;
								klon2 = kartaSiedemnastaBis;
								akcjaKlon2();
							}
						}
						
						public void klonowanieKartyOsiemnastej(){
							if(wartoscKlonu1 == false){
								kartaOsiemnasta.ustawTekst("18");
								kartaOsiemnasta.ustawNumerKarty(18);
								wartoscKlonu1 = true;
								klon1 = kartaOsiemnasta;
								akcjaKlon1();
							}
							else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
								kartaOsiemnasta.ustawTekst("18");
								kartaOsiemnasta.ustawNumerKarty(18);
								wartoscKlonu2 = true;
								klon2 = kartaOsiemnasta;
								akcjaKlon2();
							}
						}
						
						public void klonowanieKartyOsiemnastejBis(){
							if(wartoscKlonu1 == false){
								kartaOsiemnastaBis.ustawTekst("18");
								kartaOsiemnastaBis.ustawNumerKarty(18);
								wartoscKlonu1 = true;
								klon1 = kartaOsiemnastaBis;
								akcjaKlon1();
							}
							else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
								kartaOsiemnastaBis.ustawTekst("18");
								kartaOsiemnastaBis.ustawNumerKarty(18);
								wartoscKlonu2 = true;
								klon2 = kartaOsiemnastaBis;
								akcjaKlon2();
							}
						}
						
						public void klonowanieKartyDziewietnastej(){
							if(wartoscKlonu1 == false){
								kartaDziewietnasta.ustawTekst("19");
								kartaDziewietnasta.ustawNumerKarty(19);
								wartoscKlonu1 = true;
								klon1 = kartaDziewietnasta;
								akcjaKlon1();
							}
							else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
								kartaDziewietnasta.ustawTekst("19");
								kartaDziewietnasta.ustawNumerKarty(19);
								wartoscKlonu2 = true;
								klon2 = kartaDziewietnasta;
								akcjaKlon2();
							}
						}
						
						public void klonowanieKartyDziewietnastejBis(){
							if(wartoscKlonu1 == false){
								kartaDziewietnastaBis.ustawTekst("19");
								kartaDziewietnastaBis.ustawNumerKarty(19);
								wartoscKlonu1 = true;
								klon1 = kartaDziewietnastaBis;
								akcjaKlon1();
							}
							else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
								kartaDziewietnastaBis.ustawTekst("19");
								kartaDziewietnastaBis.ustawNumerKarty(19);
								wartoscKlonu2 = true;
								klon2 = kartaDziewietnastaBis;
								akcjaKlon2();
							}
						}
						
						public void klonowanieKartyDwudziestej(){
							if(wartoscKlonu1 == false){
								kartaDwudziesta.ustawTekst("20");
								kartaDwudziesta.ustawNumerKarty(20);
								wartoscKlonu1 = true;
								klon1 = kartaDwudziesta;
								akcjaKlon1();
							}
							else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
								kartaDwudziesta.ustawTekst("20");
								kartaDwudziesta.ustawNumerKarty(20);
								wartoscKlonu2 = true;
								klon2 = kartaDwudziesta;
								akcjaKlon2();
							}
						}
						
						public void klonowanieKartyDwudziestejBis(){
							if(wartoscKlonu1 == false){
								kartaDwudziestaBis.ustawTekst("20");
								kartaDwudziestaBis.ustawNumerKarty(20);
								wartoscKlonu1 = true;
								klon1 = kartaDwudziestaBis;
								akcjaKlon1();
							}
							else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
								kartaDwudziestaBis.ustawTekst("20");
								kartaDwudziestaBis.ustawNumerKarty(20);
								wartoscKlonu2 = true;
								klon2 = kartaDwudziestaBis;
								akcjaKlon2();
							}
						}
						
						public void klonowanieKartyDwudziestejPierwszej(){
							if(wartoscKlonu1 == false){
								kartaDwudziestaPierwsza.ustawTekst("21");
								kartaDwudziestaPierwsza.ustawNumerKarty(21);
								wartoscKlonu1 = true;
								klon1 = kartaDwudziestaPierwsza;
								akcjaKlon1();
							}
							else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
								kartaDwudziestaPierwsza.ustawTekst("21");
								kartaDwudziestaPierwsza.ustawNumerKarty(21);
								wartoscKlonu2 = true;
								klon2 = kartaDwudziestaPierwsza;
								akcjaKlon2();
							}
						}
						
						public void klonowanieKartyDwudziestejPierwszejBis(){
							if(wartoscKlonu1 == false){
								kartaDwudziestaPierwszaBis.ustawTekst("21");
								kartaDwudziestaPierwszaBis.ustawNumerKarty(21);
								wartoscKlonu1 = true;
								klon1 = kartaDwudziestaPierwszaBis;
								akcjaKlon1();
							}
							else if(wartoscKlonu1 == true && wartoscKlonu2 == false){
								kartaDwudziestaPierwszaBis.ustawTekst("21");
								kartaDwudziestaPierwszaBis.ustawNumerKarty(21);
								wartoscKlonu2 = true;
								klon2 = kartaDwudziestaPierwszaBis;
								akcjaKlon2();
							}
						}
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void run(){
				while(true){
					uspienieWatku1();
					porownanieKartKlonow();
					if(getLiczbaZnalezionychPar() == 21 && getKoniecGry() == false){
						setKoniecGry(true);
						
					}
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
						dodanieProby();
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
						dodanieProby();
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
								public int getLiczbaProb(){
									return liczbaProb;
								}
								
								public void dodanieProby(){
									liczbaProb++;
								}
								
								public void resetowanieLiczbyProb(int liczbaProb){
									this.liczbaProb = liczbaProb;
								}
								
								public void setLiczbaZnalezionychPar(){
									liczbaZnalezionychPar++;
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
								
								public void setKoniecGry(boolean koniecGry){
									this.koniecGry = koniecGry;
								}
								
								public boolean getKoniecGry(){
									return koniecGry;
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
