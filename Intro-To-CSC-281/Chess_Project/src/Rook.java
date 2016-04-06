import javax.swing.ImageIcon;


public class Rook extends Piece
{

	public Rook(boolean isBlack)
	{
		super(isBlack);
		if (isBlack == true)
		{
			icon = new ImageIcon("brook.gif");
		}
		else
		{
			icon = new ImageIcon("wrook.gif");
		}
	}

	@Override
	public boolean canMove(int xi, int yi, int xf, int yf) 
	{
		if((Math.abs(yf-yi) != 0) && (Math.abs(xf-xi) == 0) || (Math.abs(yf-yi) == 0) && (Math.abs(xf-xi) != 0))
		{
			
			//checks to see if there are pieces between initial and final when moving up
			for(int i = yi-1; i > yf; i--)
			{
				if(Chess.position[i][xf] != null)
				{
					return false;	
				}
			}
			
			//checks to see if there are pieces between initial and final when moving left
			for(int i = xi-1; i > xf; i--)
			{
				if(Chess.position[yf][i] != null)
				{
					return false;	
				}
			}
			
			//checks to see if there are pieces between initial and final when moving down

			for(int i = yi+1; i < yf; i++)
			{
				if(Chess.position[i][xf] != null)
				{
					return false;	
				}
			}
			
			
			//checks to see if there are pieces between initial and final when moving down
			for(int i = xi+1; i < xf; i++)
			{
				if(Chess.position[yf][i] != null)
				{
					return false;	
				}
			}
			
		}
		//if the rook attempts anything that is not in its moveset, return false
		if(!((Math.abs(yf-yi) != 0) && (Math.abs(xf-xi) == 0) || (Math.abs(yf-yi) == 0) && (Math.abs(xf-xi) != 0)))
			return false;

		
		return true;
	}

	
}
