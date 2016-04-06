import javax.swing.ImageIcon;


public class King extends Piece
{
	
	public King(boolean isBlack)
	{
		super(isBlack);
		if (isBlack == true)
		{
			icon = new ImageIcon("bking.gif");
		}
		else
		{
			icon = new ImageIcon("wking.gif");
		}
	}

	@Override
	public boolean canMove(int xi, int yi, int xf, int yf) {
		
		//King can move one square in any direction
		if((Math.abs(xf-xi) <= 1 && Math.abs(yf-yi) <= 1))
		{
					
					return true;
		}

		return false;
	}

	
	}
	

