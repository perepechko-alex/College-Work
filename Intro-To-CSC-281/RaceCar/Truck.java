import java.awt.Color;
import java.awt.Graphics;


public class Truck extends Vehicle //implements Runnable
{
	
	/*int xposition,yposition,velocity;
	Color carColor;
	*/
	public Truck(int xposition, int yposition, int velocity, Color carColor, RacecarWindow racecarwindow)
	{
		super(xposition, yposition, velocity, carColor, racecarwindow);
		
		
	}
	public void draw(Graphics g)
	{
		g.setColor(carColor);
		g.fillRect(xposition,yposition,50,15);
		g.fillRect(xposition,yposition-20,30,20);
		g.drawOval(xposition, yposition+15, 10, 10);
		g.drawOval(xposition+40, yposition+15, 10, 10);
	}
	
	/*public void run()
	{
		while(true)
		{
			if(moving)
			{
				xposition = xposition + velocity;
				racecarwindow.carcomponent.repaint();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	
}
