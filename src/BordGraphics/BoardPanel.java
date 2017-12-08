package BordGraphics;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BordGraphics.Cell.cellStatus;

public class BoardPanel extends JPanel implements MouseListener 
{
	private Cell[][] _board;
	int width = 120,hight = 120;
	JFrame _frame = new JFrame("My Frame");   
	public BoardPanel() 
	{
		
		super();
		int count =0;
		_board = new Cell[6][7];
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
					_board[i][j] = new Cell(i,j,img,true,null, null, Cell.cellStatus.Empty, i*hight, j*width, false);
					//_frame.add(arg0)(_board[i][j]);
				}
				else 
				{				
					 img = new Img("images\\dark.png", j*width, i*hight, width, hight);
					_board[i][j] = new Cell(i,j,img,true,null,null,  Cell.cellStatus.Empty,i*hight, j*width,false);
				}

			}
		}
		addMouseListener(this);
		FirstSetSoldier();
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
		/**
		 * paint the board
		 */
		super.paintComponent(g);
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				_board[i][j].getImgBackground().drawImg(g);		
			}
		}
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if(_board[i][j].getImgSoldier() != null)
				_board[i][j].getImgSoldier().drawImg(g);
			}
		}
		/**
		 * paint arrow
		 */
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if(_board[i][j].is_arrow())
				{
					Img arrow = new Img ("images\\upArrow.png",_board[i][j].get_x(),_board[i][j].get_y(),120,120);
					arrow.drawImg(g);
				}
			}
		}
	}
	public void FirstSetSoldier()
	{
		Img soldier;
		Random rand = new Random();

		int  n = rand.nextInt(3)+0;
		/**
		 * player soldiers
		 */
		for (int i = 4; i < 6; i++) 
		{
			for (int j = 0; j < 7; j++)
			{
				 n = rand.nextInt(3)+0;
				if(n == 0)
				{
					soldier = new Img("images\\Rock.png", j*120, i*120, 120,120);
					_board[i][j].setSoldierType(Cell.SoldierType.Rock);
					_board[i][j].setCellStatus(Cell.cellStatus.Red);
					_board[i][j].setImgSoldier(soldier);
				}
				else if(n==1)
				{
					soldier = new Img("images\\Paper.png", j*120, i*120, 120,120);
					_board[i][j].setSoldierType(Cell.SoldierType.Paper);
					_board[i][j].setCellStatus(Cell.cellStatus.Red);
					_board[i][j].setImgSoldier(soldier);
				}
				else if(n == 2)
				{
					soldier = new Img("images\\Scissor.png", j*120, i*120, 120,120);
					_board[i][j].setSoldierType(Cell.SoldierType.Scissors);
					_board[i][j].setCellStatus(Cell.cellStatus.Red);
					_board[i][j].setImgSoldier(soldier);
				}
			}
		}
		for (int i = 0; i <2; i++) 
		{
			for (int j = 0; j < 7; j++)
			{
				 n = rand.nextInt(3)+0;
				if(n == 0)
				{
					soldier = new Img("images\\enemy.png", j*120, i*120, 120,120);
					_board[i][j].setSoldierType(Cell.SoldierType.Rock);
					_board[i][j].setCellStatus(Cell.cellStatus.Red);
					_board[i][j].setImgSoldier(soldier);
				}
				else if(n==1)
				{
					soldier = new Img("images\\enemy.png", j*120, i*120, 120,120);
					_board[i][j].setSoldierType(Cell.SoldierType.Paper);
					_board[i][j].setCellStatus(Cell.cellStatus.Red);
					_board[i][j].setImgSoldier(soldier);
				}
				else if(n == 2)
				{
					soldier = new Img("images\\enemy.png", j*120, i*120, 120,120);
					_board[i][j].setSoldierType(Cell.SoldierType.Scissors);
					_board[i][j].setCellStatus(Cell.cellStatus.Red);
					_board[i][j].setImgSoldier(soldier);
				}
			}
		}
	}
	public IJ locationToIJ(int x,int y)
	{
		IJ ij = null;
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if(_board[i][j].get_x()<x&&	x<_board[i][j].get_x()+width
					&&_board[i][j].get_y()<y&&	y<_board[i][j].get_y()+hight)
				{
					ij = new IJ (i,j);
				}
			}
		}
		return ij;
		
	}
	public void clickedSoldier(int i,int j)
	{
		if(_board[i-1][j].get_cellStatus() == cellStatus.Empty)
		{
			repaint();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		IJ ij = locationToIJ(e.getX(),e.getY());
		int i = ij.get_i();
		int j = ij.get_j();
		clickedSoldier(i,j);
		System.out.println("ewqwqewqe");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int k;
		k=1;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
