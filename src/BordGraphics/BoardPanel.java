package BordGraphics;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BordGraphics.Cell.SoldierType;
import BordGraphics.Cell.cellStatus;

public class BoardPanel extends JPanel implements MouseListener 
{
	private Cell[][] _board;
	int width = 120,hight = 120,gameW = 7, gameH = 6;
	JFrame _frame = new JFrame("My Frame");
	IJ indexSoldierClicked;
	Vector<IJ> _arrowIJ;
	private Vector<IJ> vec;
	public static enum Directions{Straight,Left,Right,Back};
	private SoldierType directions;
	//======================================================================================================================
	public BoardPanel() 
	{

		super();
		int count =0;
		_board = new Cell[gameH+2][gameW+2];
		Img img;
		_arrowIJ = new Vector<IJ>();
		//setLayout(new GridLayout(6, 7));
		/**
		 * creat cells(created +2 rows and +2 cols because i dont want exaptions)
		 */
		for (int i = 0; i < gameH+2; i++)
		{
			for (int j = 0; j < gameW+2; j++)
			{
				count++;
				if(count%2 == 0)
				{
					img = new Img("images\\bright.png", j*width, i*hight, width, hight);

					//_frame.add(arg0)(_board[i][j]);
				}
				else 
				{				
					img = new Img("images\\dark.png", j*width, i*hight, width, hight);
					//_board[i][j] = new Cell(i,j,img,true,null,null,  Cell.cellStatus.Empty,i*hight, j*width,false);
				}
				//				if(i==0||j==0||j==gameW+2||i==gameH+2)
				//				_board[i][j] = new Cell(i,j,img,false,null, null, Cell.cellStatus.Empty,j*width , i*hight, false);
				//				else
				_board[i][j] = new Cell(i,j,img,true,null, null, Cell.cellStatus.Empty,j*width , i*hight, false);
				if(i == 0 || i == gameH+1 || j == 0 || j == gameW+1 )
				{
					_board[i][j].setCellStatus(null);
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
	//======================================================================================================================

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
		for (int i = 1; i < gameH+1; i++)
		{
			for (int j = 1; j <gameW+1; j++)
			{
				_board[i][j].getImgBackground().drawImg(g);		
			}
		}
		/**
		 * paint soldiers
		 */
		for (int i = 1; i < gameH+1; i++)
		{
			for (int j = 1; j < gameW+1; j++)
			{
				if(_board[i][j].getImgSoldier() != null)
					_board[i][j].getImgSoldier().drawImg(g);
			}
		}
		/**
		 * paint arrow
		 */
//		for (int i = 1; i < gameH+1; i++)
//		{
//			for (int j = 1; j < gameW+1; j++)
//			{
//				if(_board[i][j].isArrow())
//				{
//					Img arrow = new Img ("images\\upArrow.png",_board[i][j].getX(),_board[i][j].getY(),width,hight);
//					arrow.drawImg(g);
//
//				}
//			}
//		}
		int k ,m;
		for (int i = 0; i < _arrowIJ.size(); i++)
		{
			k = _arrowIJ.get(i).getI();
			m = _arrowIJ.get(i).getJ();
			Img arrow = new Img ("images\\clicked.png",_board[k][m].getX(),_board[k][m].getY(),width,hight);
			arrow.drawImg(g);
		}
		
		//		/**
		//		 * movemant
		//		 */
		//		for (int i = 1; i < gameH+1; i++)
		//		{
		//			for (int j = 1; j < gameW+1; j++)
		//			{
		//				if(_board[i][j].isArrow())
		//				{
		//					Img arrow = new Img ("images\\upArrow.png",_board[i][j].getX(),_board[i][j].getY(),width,hight);
		//					arrow.drawImg(g);
		//					//_board[i][j].setArrow(false);
		//				}
		//			}
		//		}

	}
	//======================================================================================================================
	/**
	 * set the first position 
	 */
	public void FirstSetSoldier()
	{
		Img soldier;
		Random rand = new Random();
		int rockCount = 0, paperCount = 0, scissorsCount = 0;
		
		int  n = rand.nextInt(3)+0;
		/**
		 * player soldiers
		 * random the soldier type(4 rock 4 paper 4 scissors)
		 */
		for (int i = 5; i < gameH+1; i++) 
		{
			for (int j = 1; j < gameW+1; j++)
			{
				n = rand.nextInt(3)+0;
				if(n == 0 && rockCount<4)
				{
					soldier = new Img("images\\Rock.png", j*width, i*hight, width,hight);
					_board[i][j].setSoldierType(Cell.SoldierType.Rock);
					_board[i][j].setCellStatus(Cell.cellStatus.Red);
					_board[i][j].setImgSoldier(soldier);
					rockCount++;
				}
				else if(n==1 && paperCount < 4)
				{
					soldier = new Img("images\\paper.png", j*width, i*hight, width,hight);
					_board[i][j].setSoldierType(Cell.SoldierType.Paper);
					_board[i][j].setCellStatus(Cell.cellStatus.Red);
					_board[i][j].setImgSoldier(soldier);
					paperCount++;
				}
				else if(n == 2 && scissorsCount< 4)
				{
					soldier = new Img("images\\Scissor.png", j*width, i*hight, width,hight);
					_board[i][j].setSoldierType(Cell.SoldierType.Scissors);
					_board[i][j].setCellStatus(Cell.cellStatus.Red);
					_board[i][j].setImgSoldier(soldier);
					scissorsCount++;
				}
			}
		}
		/**
		 * enemy
		 */
		for (int i = 1; i <3; i++) 
		{
			for (int j = 1; j < gameW+1; j++)
			{
				n = rand.nextInt(3)+0;
				if(n == 0)
				{
					soldier = new Img("images\\enemy.png", j*width, i*hight, width,hight);
					_board[i][j].setSoldierType(Cell.SoldierType.Rock);
					_board[i][j].setCellStatus(Cell.cellStatus.Blue);
					_board[i][j].setImgSoldier(soldier);
				}
				else if(n==1)
				{
					soldier = new Img("images\\enemy.png", j*width, i*hight, width,hight);
					_board[i][j].setSoldierType(Cell.SoldierType.Paper);
					_board[i][j].setCellStatus(Cell.cellStatus.Blue);
					_board[i][j].setImgSoldier(soldier);
				}
				else if(n == 2)
				{
					soldier = new Img("images\\enemy.png", j*width, i*hight, width,hight);
					_board[i][j].setSoldierType(Cell.SoldierType.Scissors);
					_board[i][j].setCellStatus(Cell.cellStatus.Blue);
					_board[i][j].setImgSoldier(soldier);
				}
			}
		}
	}
	//======================================================================================================================
	/**
	 * location to IJ
	 * @param x
	 * @param y
	 * @return
	 */
	public IJ locationToIJ(int x,int y)
	{
		IJ ij = null;
		for (int i = 1; i < gameH+1; i++)
		{
			for (int j = 1; j < gameW+1; j++)
			{
				if(_board[i][j].getX()<x&&	x<_board[i][j].getX()+width
						&&_board[i][j].getY()<y&&	y<_board[i][j].getY()+hight)
				{
					ij = new IJ (i,j);
				}
			}
		}
		return ij;

	}
	//======================================================================================================================
	/**
	 * if clicked soldier open arrows
	 * @param i
	 * @param j
	 */
	public void clickedSoldierMakeArrow(int i,int j)
	{
		
		if(_board[i][j].getCellStatus() == Cell.cellStatus.Red)
		{
			if (_board[i-1][j].getCellStatus() == Cell.cellStatus.Empty)
			{
				_board[i-1][j].setArrow(true);
				_arrowIJ.addElement(new IJ(i-1,j));
			}
			if (_board[i+1][j].getCellStatus() == Cell.cellStatus.Empty)
			{
				_board[i+1][j].setArrow(true);
				_arrowIJ.addElement(new IJ(i+1,j));
			}
			if (_board[i][j-1].getCellStatus() == Cell.cellStatus.Empty)
			{
				_board[i][j-1].setArrow(true);
				_arrowIJ.addElement(new IJ(i,j-1));
			}
			if (_board[i][j+1].getCellStatus() == Cell.cellStatus.Empty)
			{
				_board[i][j+1].setArrow(true);
				_arrowIJ.addElement(new IJ(i,j+1));
			}
		}
		//System.out.println(_arrowIJ.toString());
		repaint();
	}
	//======================================================================================================================
	/**
	 * get cur i
	 * cur j
	 * indexSoldierClicked
	 * Move Soldier
	 * @param i
	 * @param j
	 * @param indexSoldierClicked
	 */
	public void MoveSoldier(int i,int j)
	{ 
		/**
		 * current soldier
		 */
		Img curSoldier = null;
		SoldierType soldier = null;
		cellStatus cellStatus = null;
		if(_board[indexSoldierClicked.getI()][indexSoldierClicked.getJ()].getSoldierType() == Cell.SoldierType.Rock)
		{
			curSoldier = new Img("images\\Rock.png", j*width, i*hight, width,hight);
			soldier = Cell.SoldierType.Rock;
			cellStatus = Cell.cellStatus.Red;
		}
		else if(_board[indexSoldierClicked.getI()][indexSoldierClicked.getJ()].getSoldierType() == Cell.SoldierType.Paper)
		{
			curSoldier =  new Img("images\\paper.png", j*width, i*hight, width,hight);
			soldier = Cell.SoldierType.Paper;
			cellStatus = Cell.cellStatus.Red;
		}
		else if(_board[indexSoldierClicked.getI()][indexSoldierClicked.getJ()].getSoldierType() == Cell.SoldierType.Scissors)
		{
			curSoldier= new Img("images\\Scissor.png", j*width, i*hight, width,hight);
			soldier = Cell.SoldierType.Scissors;
			cellStatus = Cell.cellStatus.Red;
		}
		if (_board[i][j].isArrow())
		{
			_board[i][j].setImgSoldier(curSoldier);
			_board[i][j].setSoldierType(soldier);
			_board[i][j].setCellStatus(cellStatus);
		}
		//		if (_board[i-1][j].isArrow())
		//		{
		//			_board[i-1][j].setImgSoldier(curSoldier);
		//      		_board[i-1][j].setSoldierType(soldier);
		//			_board[i-1][j].setCellStatus(cellStatus);
		//		}
		//		else if (_board[i+1][j].isArrow())
		//		{
		//			_board[i+1][j].setImgSoldier(curSoldier);
		//			_board[i+1][j].setSoldierType(soldier);
		//			_board[i+1][j].setCellStatus(cellStatus);
		//		}	
		//		else if (_board[i][j-1].isArrow())
		//		{
		//			_board[i][j-1].setImgSoldier(curSoldier);
		//			_board[i][j-1].setSoldierType(soldier);
		//			_board[i][j-1].setCellStatus(cellStatus);
		//		}
		//		else if (_board[i][j+1].isArrow())
		//		{
		//			_board[i][j+1].setSoldierType(soldier);
		//			_board[i][j+1].setImgSoldier(curSoldier);
		//			_board[i][j+1].setCellStatus(cellStatus);
		//		}
		//_board[_arrowIJ.get(0).getI()][_arrowIJ.get(0).getJ()].setArrow(false);
		_board[indexSoldierClicked.getI()][indexSoldierClicked.getJ()].setImgSoldier(null);
		_board[indexSoldierClicked.getI()][indexSoldierClicked.getJ()].setSoldierType(null);
		_board[indexSoldierClicked.getI()][indexSoldierClicked.getJ()].setCellStatus(Cell.cellStatus.Empty);
		
		repaint();
//		for(int k =0;k<_arrowIJ.size();k++)
//		{
//
//			_board[_arrowIJ.get(k).getI()][_arrowIJ.get(k).getJ()].setArrow(false);
//
//			System.out.println(_arrowIJ.toString());
//			
//
//		}
//		_arrowIJ.removeAllElements();
	}
	//======================================================================================================================
	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

		IJ ij = locationToIJ(e.getX(),e.getY());
		int i = ij.getI();
		int j = ij.getJ();
		int flag = 0;
		int count = 0;
		if(_board[i][j].getCellStatus() == Cell.cellStatus.Red)
		{
			//if(count != 0)
			//{
				removeArrowFromVertor();
			//}
			clickedSoldierMakeArrow(i,j);
			indexSoldierClicked = new IJ(i, j);
			count++;
			//System.out.println(count);
			
		}
		/**
		 * if clicked on arrow so move the soldier
		 */
		if (_board[i][j].getCellStatus() == Cell.cellStatus.Empty && _board[i][j].isArrow())
		{
			MoveSoldier(i,j);
			flag = 0;
		}
		//if((indexSoldierClicked.getI() !=i || indexSoldierClicked.getJ()!=j ) && flag != 0)
		//{
			//System.out.println(_arrowIJ.toString());
		/**
		 * if clicked on emty and no arrow in the cell so clean the arrows
		 */
		if (_board[i][j].getCellStatus() == Cell.cellStatus.Empty && !_board[i][j].isArrow())
		{
			removeArrowFromVertor();
			flag = 1;
			repaint();
		}
		if((indexSoldierClicked.getI() !=i || indexSoldierClicked.getJ()!=j) && flag == 0)
		{
			removeArrowFromVertor();
			//System.out.println("asdasd");
//			for(int k =0;k<_arrowIJ.size();k++)
//			{
//				_board[_arrowIJ.get(k).getI()][_arrowIJ.get(k).getJ()].setArrow(false);
//				System.out.println(_arrowIJ.toString());
//			}
//			_arrowIJ.removeAllElements();
			//flag = 0;
			///count = 0;
		//}
		//count++;
		}
		//repaint();

	}
	//======================================================================================================================
	/**
	 * remove Arrow From Vertor and change to false
	 */
	public void removeArrowFromVertor()
	{
		for(int k =0;k<_arrowIJ.size();k++)
		{
			_board[_arrowIJ.get(k).getI()][_arrowIJ.get(k).getJ()].setArrow(false);
			//System.out.println(_arrowIJ.toString());
		}
		_arrowIJ.removeAllElements();
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
		//int k;
		//		k=1;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
