package MemoryMasterPakiet;

public class KartaPierwsza extends KartaGlowna{
	
	private boolean wybranaKarta = true;
	private String wartoscKartyString = "1";
	private boolean wybranaPara = true;
	
	public KartaPierwsza(){
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
	
	public void setWybranaPara(boolean wybranaPara){
		this.wybranaPara = wybranaPara;
	}
	
	public boolean getWybranaPara(){
		return wybranaPara;
	}
	
}
