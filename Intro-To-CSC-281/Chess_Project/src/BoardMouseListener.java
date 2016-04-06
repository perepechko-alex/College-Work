import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class BoardMouseListener implements MouseListener{

	//declare click initial for x and y coordinates, and the final click for x and y
	//initial = when button is pressed, final = when button is released
	int clickxi, clickyi, clickxf, clickyf;
	boolean whiteTurn = true;
	Chess chesswindow;


	
	public BoardMouseListener(Chess chesswindow)
	{
		this.chesswindow = chesswindow;
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mousePressed(MouseEvent e) {
		//get the coodrinates and divide it by 44 to get appropriate array position
		clickxi = e.getX()/44;
		clickyi= e.getY()/44;
		//System.out.println(clickxi);
		//System.out.println(clickyi);

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//divide by 44 to get position of the piece in array
		clickxf = e.getX()/44;
		clickyf = e.getY()/44;
		
		System.out.println("X-initial is: " + clickxi); //testing
		System.out.println("Y-initial is: " + clickyi); //testing
		
		System.out.println("\nX-final is: " + clickxf); //testing
		System.out.println("Y-final is: " + clickyf); //testing
		System.out.println(); //testing
		
		//checks to see if valid move has been made
		if(((clickyi <= 7 && clickxi <=7) && (clickyf <=7 && clickxf <=7))//checks to see if click is out of bounds
				&& (clickxi >= 0 && clickxf >=0) && (clickyi >=0 && clickyf >=0) //checks if click is out of bounds
				&& (Chess.position[clickyi][clickxi] != null) //checks if the user clicks on an empty space
				&& //(Chess.position[clickyi][clickxi].isBlack == true && !whiteTurn && (Chess.position[clickyf][clickxf] == null || Chess.position[clickyf][clickxf].isBlack == false) //specifies where white pieces can move and only move on white turn, and that they can only take black pieces
				Chess.position[clickyi][clickxi].isBlack == false && whiteTurn && (Chess.position[clickyf][clickxf] == null || Chess.position[clickyf][clickxf].isBlack == true) //specifies where black pieces can move and that they can only take white pieces
				&& Chess.position[clickyi][clickxi].canMove(clickxi, clickyi, clickxf, clickyf) == true) //checks if canMove method returns true, and if
			
		{
			//sets the position of the piece to where the mouse was released
			Chess.position[clickyf][clickxf] = Chess.position[clickyi][clickxi];
			
			//sets the position in which the piece was in to null
			Chess.position[clickyi][clickxi] = null;
			
			//repaints board 
			chesswindow.boardcomponent.repaint();
			
			whiteTurn = !whiteTurn;
			System.out.println(whiteTurn);
			//System.out.println(rx);
			//System.out.println(ry);
			
			//AI Method
			if(!whiteTurn){//if it isn't white turn, do the method
			while(true){ // while the following conditions are true, check the entire board for a random black piece and see if it can make a random move
			for(int y = 0; y < Chess.position.length; y++) 
			{
				
				for(int x = 0; x < Chess.position.length; x++)
				{
					//generates a random end x and end y if the chosen piece is black
					if(Chess.position[y][x] != null && Chess.position[y][x].isBlack)
					{
						
						Random rand = new Random();
						int rx = rand.nextInt(7);
						int ry = rand.nextInt(7);
						
						//checks to see if piece can make valid move and then updates its position when it makes a move
						if(Chess.position[y][x].isBlack &&(Chess.position[ry][rx] == null || !Chess.position[ry][rx].isBlack) && Chess.position[y][x].canMove(x, y, rx, ry))
						{
					
							Chess.position[ry][rx] = Chess.position[y][x];
							Chess.position[y][x] = null;
					
							//change turn back to white turn
							whiteTurn = !whiteTurn;
							System.out.println(whiteTurn);
							return;
						}
					}
				
		}
		}
			}
		}
	}
	}
}

