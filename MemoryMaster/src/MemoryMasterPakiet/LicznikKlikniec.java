package MemoryMasterPakiet;

public class LicznikKlikniec {
	
	private int liczbaKlikniec = 0;
	
	public LicznikKlikniec(){
		
	}
	
	public int getLiczbaKlikniec(){
		return liczbaKlikniec;
	}
	
	public void setKlikniecie(){
		this.liczbaKlikniec++;
	}
	
	public void resetujLiczbeKlikniec(){
		this.liczbaKlikniec = 0;
	}
}
