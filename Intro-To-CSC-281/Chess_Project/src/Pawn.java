import javax.swing.ImageIcon;


public class Pawn extends Piece
{


public Pawn(boolean isBlack)
{
	super(isBlack);
	if (isBlack == true)
	{
		icon = new ImageIcon("bpawn.gif");
	}
	else
	{
		icon = new ImageIcon("wpawn.gif");
	}
}

@Override
public boolean canMove(int xi, int yi, int xf, int yf) 
{
	//white pawn
	if((!Chess.position[yi][xi].isBlack) && (yf-yi == -1 && xf-xi == 0) || //if white pawn, it can move up
			(yf - yi == -1 && xf-xi == -1) && ( Chess.position[yf][xf] != null && Chess.position[yf][xf].isBlack)|| //can attack diagonally up-left
			(yf - yi == -1 && xf-xi == 1) && ( Chess.position[yf][xf] != null && Chess.position[yf][xf].isBlack)|| //can attack diagonally up-right
			(yi-8 == -2 && Math.abs(yf-yi) == 2 && xi == xf)) //if pawn is in starting position, it can move two spaces up
				for(int i = yi-1; i >= yf && xf==xi; i--)
					if(Chess.position[i][xf] != null)
						return false;
	
	//white pawn -- if the pawn tries to move but any move other than what a pawn can move is specified, return false
	if((!Chess.position[yi][xi].isBlack) &&  !((yf-yi == -1 && xf-xi == 0) ||
			(yf - yi == -1 && xf-xi == -1) && ( Chess.position[yf][xf] != null && Chess.position[yf][xf].isBlack)||
			(yf - yi == -1 && xf-xi == 1) && ( Chess.position[yf][xf] != null && Chess.position[yf][xf].isBlack)||
			(yi-8 == -2 && Math.abs(yf-yi) == 2 && xi == xf)))
				return false;
	
	//black pawn -- same code as white pawn essentially, except it can attack diagonally down-left/right
	if((Chess.position[yi][xi].isBlack) && (yf-yi == 1 && xf-xi == 0) ||
			((yf - yi == 1 && xf-xi == 1)&& (Chess.position[yf][xf] != null && !Chess.position[yf][xf].isBlack)||
			(yf - yi == 1 && xf-xi == -1) && (Chess.position[yf][xf] != null && !Chess.position[yf][xf].isBlack) ||
			(3-yi == 2 && Math.abs(yf-yi) == 2 && xi == xf))) //if pawn is in starting position, it can move two spaces up
				for(int i = yi+1; i <= yf && xf==xi; i++)
					if(Chess.position[i][xf] != null)
						return false;
	
	//black pawn -- if the pawn tries to move but any move other than what a pawn can move is specified, return false
	if((Chess.position[yi][xi].isBlack)&&!((yf-yi == 1 && xf-xi == 0) ||
			(yf - yi == 1 && xf-xi == 1) && (Chess.position[yf][xf] != null && !Chess.position[yf][xf].isBlack)||
			(yf - yi == 1 && xf-xi == -1) && (Chess.position[yf][xf] != null && !Chess.position[yf][xf].isBlack) ||
			(3-yi == 2 && Math.abs(yf-yi) == 2) && xi == xf))
				return false;

		return true;
}

}
