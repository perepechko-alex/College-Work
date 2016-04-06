import java.awt.Color;
import java.awt.Graphics;

public class Car extends Vehicle //implements Runnable
{
	/*int xposition,yposition,velocity;
	Color carColor;
	*/
	public Car(int xposition, int yposition, int velocity, Color carColor, RacecarWindow racecarwindow)
	{
		super(xposition, yposition, velocity, carColor, racecarwindow);
		//this.racecarwindow=racecarwindow;
		
	}

	public void draw(Graphics g)
	{
		g.setColor(carColor);
		g.fillRect(xposition,yposition,50,15);
		g.drawOval(xposition, yposition+s, 10, 10);
		g.drawOval(xposition+40, yposition+s, 10, 10);
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
