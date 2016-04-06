//import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
public abstract class Piece 
{

	int xposition, yposition;
	ImageIcon icon;
	boolean isBlack, canMove;
	int xi, xf, yi, yf;
	//Chess chesswindow;
	
	//checks to see if piece is black or white when initialized -- same for all subclasess 
	public Piece(boolean isBlack)
	{
		this.isBlack = isBlack;
	}
	
	//draws the piece by getting the piece's image, and setting up the x and y positions of where
	//the piece is going to be drawn.
	public void drawPiece(Graphics g, int xposition, int yposition)
	{
		g.drawImage(icon.getImage(),xposition,yposition,null);
	}

	//creates abstract method canMove that allows for all of Piece's subclasses to
	//have a canMove method that sets a valid moveset for the particular piece.
	public abstract boolean canMove(int xi, int xy, int yi, int yf);
	

}
