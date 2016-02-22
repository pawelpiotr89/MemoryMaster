package MemoryMasterPakiet;

public class KartaPodstawowa extends KartaGlowna{
	
	private String wartoscKartyString = "";
	private int numerKarty = 0;
	
	public KartaPodstawowa(){
	}
	
	public void wyborTejKarty(){
		ustawBialeTlo();
		zablokowanieKarty();
	}
	
	public void ustawNumerKarty(int numerKarty){
		this.numerKarty = numerKarty;
	}
	
	public int getNumerKarty(){
		return numerKarty;
	}
	
	public void ustawTekst(String wartoscKartyString){
		this.setText(wartoscKartyString);
	}
}
