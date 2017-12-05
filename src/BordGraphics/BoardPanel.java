package BordGraphics;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardPanel extends JPanel 
{
	private Cell[][] _board;
	JFrame _frame = new JFrame("My Frame");   
	public BoardPanel() 
	{
		
		super();
		int count =0;
		_board = new Cell[6][7];
		int width = 120,hight = 120;
		Img img,soldier;
		
		//setLayout(new GridLayout(6, 7));
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				count++;
				if(count%2 == 0)
				{
					 img = new Img("images\\bright.png", j*width, i*hight, width, hight);
					_board[i][j] = new Cell(i,j,img,true,null, null);
					//_frame.add(arg0)(_board[i][j]);
				}
				else 
				{				
					 img = new Img("images\\s.png", j*width, i*hight, width, hight);
					_board[i][j] = new Cell(i,j,img,true,null,null);
				}

			}
		}
		_frame.add(this);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    _frame.setSize(1000,1000);
	    _frame.setVisible(true);
	}
	/**
	 * draw
	 */
	protected void paintComponent(Graphics g)
	{
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				_board[i][j].getImgBackground().drawImg(g);		
			}
		}
	}
	public void FirstSetSoldier(Graphics g)
	{
		for (int i = 0; i < 2; i++) 
		{
			for (int j = 0; j < 7; j++)
			{
				_board[i][j].setSoldierType(_board[i][j].)
			}
		}
	}
}
