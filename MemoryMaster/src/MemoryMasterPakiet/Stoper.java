package MemoryMasterPakiet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

import org.apache.commons.lang3.time.StopWatch;

public class Stoper extends JLabel implements ActionListener {
	
	Timer timer = new Timer(1000,this);
	StopWatch stoper = new StopWatch();
	
	public Stoper(){	
	}
	
	public void startCzas(){
	}
	
	public void stopCzas(){
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
		public void startStoper(){
			stoper.start();
		}
		
		public void stopStoper(){
		}
	
		public void pobierzCzasStopera(){
			stoper.getSplitTime();
		}

	
}
