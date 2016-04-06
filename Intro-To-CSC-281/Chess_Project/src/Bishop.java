import javax.swing.ImageIcon;


public class Bishop extends Piece
{
	
	public Bishop(boolean isBlack)
	{
		super(isBlack);
		if (isBlack == true)
		{
			icon = new ImageIcon("bbishop.gif");
		}
		else
		{
			icon = new ImageIcon("wbishop.gif");
		}
	}

	@Override
	public boolean canMove(int xi, int yi, int xf, int yf) {
		
		int j = yi-1;
		int k = yi+1;
		
		//check to see if the piece can move up-left
		if((Math.abs(yf-yi) == Math.abs(xf-xi)))
		{
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
		//if can't make valid bishop move in the first place, don't move the piece.
			if(!((Math.abs(yf-yi) == Math.abs(xf-xi))))
				return false;
			
		return true;
	}

	
	}

