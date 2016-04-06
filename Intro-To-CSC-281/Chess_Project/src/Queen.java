import javax.swing.ImageIcon;


public class Queen extends Piece
{

	
	public Queen(boolean isBlack)
	{
		super(isBlack);
		if (isBlack == true)
		{
			icon = new ImageIcon("bqueen.gif");
		}
		else
		{
			icon = new ImageIcon("wqueen.gif");
		}
}

	@Override
	public boolean canMove(int xi, int yi, int xf, int yf) {
		
		//Queen checks bishop moveset
		if((Math.abs(yf-yi) == Math.abs(xf-xi)))
		{
			
			int j = yi-1;
			int k = yi+1;
			
			//check to see if the piece can move up-left
			for(int i = xi-1; i > xf && j > yf; i--, j--)
			{
				if(Chess.position[j][i] != null)
				{
					return false;	
				}
			}			
			
			//check to see if piece can move up-right
			for(int i = xi+1; i < xf && j > yf ; i++, j--)
			{
				if(Chess.position[j][i] != null)
				{
					return false;	
				}
			}
			//check to see if piece can move down-left
			for(int i = xi-1; i > xf && k < yf; i--, k++)
			{
				if(Chess.position[k][i] != null)
				{
					return false;	
				}
			}
			//check to see if piece can move down-right

			for(int i = xi+1; i < xf && k < yf; i++, k++)
			{
				if(Chess.position[k][i] != null)
				{
					return false;	
				}
			}
			
	}
		//queen checks rook moveset
		else if ((((Math.abs(yf-yi) != 0) && (Math.abs(xf-xi)) == 0) || ((Math.abs(yf-yi) == 0) && (Math.abs(xf-xi) != 0))))
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
			
			//checks to see if there are pieces between initial and final when moving right
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
		//if the Queen attempts anything that is not in its moveset, return false
		if(!((Math.abs(yf-yi) == Math.abs(xf-xi)) || (((Math.abs(yf-yi) != 0) && (Math.abs(xf-xi) == 0)) || ((Math.abs(yf-yi) == 0) && (Math.abs(xf-xi) != 0)))))
			return false;
		
		return true;

	}
		
}