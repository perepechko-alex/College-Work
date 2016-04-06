import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;


public class BoardComponent extends JComponent
{
	Chess chess;
	//constructor
	public BoardComponent(Chess chess)
	{
		super();
		this.chess = chess;
	}
	

	
	public void paintComponent(Graphics g)
	{
		
		for (int i = 0; i < 4; i++) //loops through each row -- reason for 4 is that it prints out 4 squares
		{
			for(int j = 0; j < 8; j++) //loops through each column/row
			{
				//fills the brown and tan square in even rows and even columns
				if(j % 2 == 0)
				{
					g.setColor(new Color(177,113,24));
					//g.setColor(new Color(255,122,255));
					g.fillRect(88*i+44, j*44 ,44,44); //draw even row
					g.setColor(new Color(233,174,95));
					g.fillRect(88*i, 44*j ,44,44); //draw even column
				
				}
				
				//fills the brown and tan squares in odd rows and odd columns
				else
				{
					
					g.setColor(new Color(233,174,95));
					g.fillRect(88*i+44, 44*j,44,44); //draw odd row
					
					g.setColor(new Color(177,113,24));
					g.fillRect(88*i, j*44,44,44); //draw odd column

				}
			}
		}
		//drawing images of pieces into a board. Algorithm is not correct
		for(int y = 0; y < Chess.position.length; y++) // goes through each column
		{
			
			for(int x = 0; x < Chess.position.length; x++) //goes through each row

				if(Chess.position[x][y] != null) //if there is a piece that is supposed to be in a certain position, put it there
				{
					Chess.position[x][y].drawPiece(g, 44*y, x*44); //puts piece in appropriate square
					//System.out.println(chess.position[x][y]);
					//System.out.println(x);
					//System.out.println(y);
				}
			}
				
		}
		//chess.position[0][0].drawPiece(g);


	}