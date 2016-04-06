import java.awt.Color;
import java.awt.Graphics;

public abstract class Vehicle implements Runnable 
{
	int xposition,yposition,velocity,s = 15;
	
	//create variable newVelocity so that the original velocity can be incremented in velocity() method, while
	//still incrementing by the velocity passed in the constructor
	int newVelocity;

	boolean moving;
	Color carColor;
	RacecarWindow racecarwindow;
	
	public Vehicle(int xposition, int yposition, int velocity, Color carColor, RacecarWindow racecarwindow)
	{
		this.xposition = xposition;
		this.yposition = yposition;
		this.velocity = velocity;
		this.carColor = carColor;
		newVelocity = velocity;
		this.racecarwindow = racecarwindow;
		moving = false;		
	}
	
	public void draw(Graphics g)
	{
		g.setColor(carColor);
		g.fillRect(xposition,yposition,50,15);
		g.drawOval(xposition, yposition+s, 10, 10);
		g.drawOval(xposition+40, yposition+s, 10, 10);
	}
	
	public boolean wasClicked(int clickx, int clicky)
	{
		if((Math.abs((clickx - xposition)) < xposition) && ((Math.abs(clicky - yposition)) <  s*3))
			return true;
		return false;
	}
	
	public void velocity()
	{
		System.out.println("This vehicle's velocity is: " + newVelocity);
		newVelocity+=velocity;
		moving = true;
	}
	
	
	public void run()
	{
		while(true)
		{
			if(moving)
			{
				xposition = xposition + newVelocity;
				//System.out.println(xposition);
				racecarwindow.carcomponent.repaint();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}