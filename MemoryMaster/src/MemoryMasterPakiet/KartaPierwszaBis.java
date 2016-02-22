package MemoryMasterPakiet;

public class KartaPierwszaBis  extends KartaGlowna {

	private boolean wybranaKarta = true;
	private String wartoscKartyString = "1";
	
	public KartaPierwszaBis(){
	}
	
	public void wyborTejKarty(){
		ustawBialeTlo();
		ustawTekst();
		setStanKarty(false);
	}
	
	public void zlyWybor(){
		this.odblokowanieKarty();
	}
	
	public void ustawTekst(){
		this.setText(wartoscKartyString);
	}
	
	public void setStanKarty(boolean wybranaKarta){
		this.wybranaKarta = wybranaKarta;
	}
	
	public boolean getStanKarty(){
		return wybranaKarta;
	}	
}

