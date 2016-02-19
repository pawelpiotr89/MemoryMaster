package MemoryMasterPakiet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

import org.apache.commons.lang3.time.StopWatch;

public class Stoper extends JLabel{
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    
    final private int szerokoscRamki = screenSize.width;
    final private int wysokoscRamki = screenSize.height;
    final private double szerokoscEtykietyCzasDouble = szerokoscRamki * 0.2;
    final private int szerokoscEtykietyCzasInteger = (int) szerokoscEtykietyCzasDouble;
    final private double wysokoscEtykietyCzasDouble = wysokoscRamki / 20;
    final private int wysokoscEtykietyCzasInteger = (int) wysokoscEtykietyCzasDouble;
    final private double rozmiarCzcionkiDouble = szerokoscRamki / 50;
    final private int rozmiarCzcionkiInteger = (int) rozmiarCzcionkiDouble;
	
	Timer timer;
	StopWatch stopWatch = new StopWatch();
	
	public Stoper(){
		setForeground(Color.WHITE);
		setBackground(new Color(0, 148, 255));
		setMaximumSize(new Dimension(szerokoscEtykietyCzasInteger, wysokoscEtykietyCzasInteger));
		setFont(new Font("Tahoma", Font.BOLD, rozmiarCzcionkiInteger));
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setText("00:00:00.000");
		
		timer = new Timer(1, new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	getStringCzas();
				}
			});
	}
	
	public void startCzas(){
		startTimer();
		startStoper();
	}
	
	public void stopCzas(){
		stopTimer();
		stopStoper();
		resetStoper();
	}
	
	public void getStringCzas(){
		setText(czasDoStringa());
	}
	
	public String czasDoStringa(){
		splitStoper();
		return stopWatch.toSplitString();
	}
	
	public void resetStoper(){
		stopWatch.reset();
		wyzerowanieZegara();
	}
	
		public void startStoper(){
			stopWatch.start();
		}
		
		public void stopStoper(){
			stopWatch.stop();
		}
	
		public void startTimer(){
			timer.start();
		}
		
		public void stopTimer(){
			timer.stop();
		}
		
		public void splitStoper(){
			stopWatch.split();
		}
		
		public void wyzerowanieZegara(){
			setText("00:00:00.000");
		}
		
		public boolean sprawdzenieCzyDziala(){
			return stopWatch.isStarted();
		}
}
