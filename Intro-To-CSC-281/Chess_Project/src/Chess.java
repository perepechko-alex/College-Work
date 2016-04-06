import javax.swing.JFrame;


public class Chess {
	
	static final int WINDOWWIDTH = 352, WINDOWHEIGHT = 352;
	
	
	BoardComponent boardcomponent;
	BoardMouseListener boardmouselistener;
	
	//creates 2D array for where the pieces will be located on the board
	static Piece[][] position;

	public Chess()
	{
		//initializes the 2D array into an 8x8 grid
				position = new Piece[8][8];
				
				//Initializing all the pieces into their appropriate locations on the chess board
				
				//a for loop that initializes the column in which the pawns are in for their appropriate row
				for(int i = 0; i < 8; i++)
				{
					position[1][i] = new Pawn(true);
					position[6][i] = new Pawn(false);
				}
				
				//initializes black and white pieces -- true denotes black, false denotes white
				position[0][1] = new Knight(true);
				position[0][6] = new Knight(true);
				position[7][1] = new Knight(false);
				position[7][6] = new Knight(false);
				
				position[0][2] = new Bishop(true);
				position[0][5] = new Bishop(true);
				position[7][2] = new Bishop(false);
				position[7][5] = new Bishop(false);
				
				position[0][0] = new Rook(true);
				position[0][7] = new Rook(true);
				position[7][0] = new Rook(false);
				position[7][7] = new Rook(false);

				position[0][4] = new King(true);
				position[7][4] = new King(false);
				
				position[0][3] = new Queen(true);
				position[7][3] = new Queen(false);
				
				
		//sets up the chessboard window
		JFrame chesswindow;
		chesswindow = new JFrame("Chess");
		chesswindow.setSize(WINDOWWIDTH, WINDOWHEIGHT);
		chesswindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		//adds boardcomponent and mouselistener to chess window	
		boardcomponent = new BoardComponent(this);
		
		chesswindow.add(boardcomponent);
		
		boardmouselistener = new BoardMouseListener(this);
		chesswindow.addMouseListener(boardmouselistener);
		
		chesswindow.setVisible(true);
		}

	
	
	public static void main(String[] args) 
	{
		//calls the window and allows for it to be displayed
		new Chess();
	}
	
	
	
}
