import javax.swing.ImageIcon;


public class Knight extends Piece
{

	public Knight(boolean isBlack)
	{
		super(isBlack);
		if (isBlack == true)
		{
			icon = new ImageIcon("bknight.gif");
		}
		else
		{
			icon = new ImageIcon("wknight.gif");
		}
	}

	@Override
	public boolean canMove(int xi, int yi, int xf, int yf) {
	
		//checks to see if the knight has moved appropriately -- don't need to worry about knight not being able
		//to jump over pieces, so no statement for that
		if((((Math.abs(yf-yi) == 2)) && Math.abs(xf-xi) ==1) || ((Math.abs(yf-yi) == 1) && (Math.abs(xf-xi) == 2)))
		{
			
					return true;
		}
		return false;
	}

	
	}

