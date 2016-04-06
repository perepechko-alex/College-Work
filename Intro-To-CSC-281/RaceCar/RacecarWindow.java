import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class RacecarWindow extends JComponent implements MouseListener
{

	static final int WINDOWWIDTH = 600, WINDOWHEIGHT = 500;

	Car[] cars;
	Truck[] trucks;
	CarComponent carcomponent;

	public RacecarWindow() {

		JFrame carwindow;
		carwindow = new JFrame("Car Window");
		carwindow.setSize(WINDOWWIDTH, WINDOWHEIGHT);
		carwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create list of cars
		cars = new Car[3];
		for (int i = 0; i < cars.length; i++) {
			cars[0] = new Car(50, 50, 10, new Color(255, 135, 44), this);
			cars[1] = new Car(50, 260, 12, new Color(200, 185, 236), this);
			cars[2] = new Car(50, 330, 13, new Color(26, 199, 234), this);
		}

		// Create list of trucks
		trucks = new Truck[2];
		for (int i = 0; i < trucks.length; i++) {
			trucks[0] = new Truck(50, 120, 5, new Color(50, 135, 44), this);
			trucks[1] = new Truck(50, 190, 7, new Color(122, 135, 154), this);

		}

		// Allows for carcomponent to be painted on the window
		carcomponent = new CarComponent(this);

		carwindow.add(carcomponent);
		carwindow.addMouseListener(this);

		carwindow.setVisible(true);

		// Starts thread for cars and trucks
		for (int i = 0; i < cars.length; i++)
			new Thread(cars[i]).start();

		for (int i = 0; i < trucks.length; i++)
			new Thread(trucks[i]).start();

	}

	public static void main(String[] args) {
		new RacecarWindow();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// System.out.println("The window was clicked" + " " + e.getX() + " " +
		// e.getY());
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].wasClicked(e.getX(), e.getY()))
				cars[i].velocity();
		}
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i].wasClicked(e.getX(), e.getY()))
				trucks[i].velocity();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
