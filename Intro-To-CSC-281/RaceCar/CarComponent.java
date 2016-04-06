import java.awt.Graphics;
//import java.awt.Color;

import javax.swing.JComponent;

public class CarComponent extends JComponent{
	
	RacecarWindow racecarwindow;
	
	public CarComponent(RacecarWindow racecarwindow)
	{
		super();
		this.racecarwindow = racecarwindow;
	}
	
	public void paintComponent(Graphics g)
	{
		for(int i = 0; i < racecarwindow.cars.length; i++)
			racecarwindow.cars[i].draw(g);
		
		for(int i = 0; i < racecarwindow.trucks.length; i++)
			racecarwindow.trucks[i].draw(g);			
	}
}
