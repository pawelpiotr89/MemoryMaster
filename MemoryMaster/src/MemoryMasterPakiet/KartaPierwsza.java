package MemoryMasterPakiet;

public class KartaPierwsza extends KartaGlowna{
	
	public KartaPierwsza(){
	}
	
	@Override
	public boolean equals(Object kartaPierwszaBis) 
	{
		if (kartaPierwszaBis instanceof KartaPierwsza){
			KartaPierwsza kartaPierwsza = (KartaPierwsza) kartaPierwszaBis;
			return true;
		}
		else return false;
	}
}
