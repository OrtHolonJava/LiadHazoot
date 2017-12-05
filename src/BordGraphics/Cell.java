package BordGraphics;

import java.awt.Graphics;

public class Cell 
{
	private int _row;
	private int _col;
	private Img _imgBackground; 
	private enum SoldierColor{Red,Blue,Empty};
	private boolean _isPosibleCell;
	private Img _imgSoldier;
	private enum SoldierType{Rock,Paper,Scissors};
	private  static SoldierType _soldierType;
	public Cell(int row, int col, Img imgBackground, boolean isPosibleCell, Img imgSoldier,SoldierType soldierType) 
	{
		_row = row;
		_col = col;
		_imgBackground = imgBackground;
		_isPosibleCell = isPosibleCell;
		_imgSoldier = imgSoldier;
		_soldierType = soldierType;
	}
	public SoldierType getSoldierType() {
		return _soldierType;
	}
	public void setSoldierType(SoldierType soldierType) {
		_soldierType = soldierType;
	}
	public int getRow() {
		return _row;
	}
	public void setRow(int row) {
		_row = row;
	}
	public int getCol() {
		return _col;
	}
	public void setCol(int col) {
		_col = col;
	}
	public Img getImgBackground() {
		return _imgBackground;
	}
	public void setImgBackground(Img imgBackground) {
		_imgBackground = imgBackground;
	}
	public boolean isPosibleCell() {
		return _isPosibleCell;
	}
	public void setPosibleCell(boolean isPosibleCell) {
		_isPosibleCell = isPosibleCell;
	}
	public Img getImgSoldier() {
		return _imgSoldier;
	}
	public void setImgSoldier(Img imgSoldier) {
		_imgSoldier = imgSoldier;
	}
	public void drawSoldier(Graphics g)
	{
		_imgSoldier.drawImg(g);
	}
}
