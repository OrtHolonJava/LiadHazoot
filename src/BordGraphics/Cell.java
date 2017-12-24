package BordGraphics;

import java.awt.Graphics;

public class Cell 
{
	private int _row;
	private int _col;
	private Img _imgBackground; 
	public static enum cellStatus{Red,Blue,Empty};
	private cellStatus _cellStatus;
	private boolean _isPosibleCell;
	private Img _imgSoldier;
	public static enum SoldierType{Rock,Paper,Scissors};
	private SoldierType _soldierType;
	private int _x;
	private int _y;
	private boolean _arrow = false;
	
	public Cell(int row, int col, Img imgBackground, boolean isPosibleCell, 
			Img imgSoldier,SoldierType soldierType,cellStatus cellStatus,int x,int y,boolean arrow) 
	{
		_row = row;
		_col = col;
		_imgBackground = imgBackground;
		_isPosibleCell = isPosibleCell;
		_imgSoldier = imgSoldier;
		_soldierType = soldierType;
		_cellStatus = cellStatus;
		_x=x;
		_y=y;
		_arrow = arrow;
	}
	public boolean isArrow() {
		return _arrow;
	}
	public void setArrow(boolean arrow) {
		this._arrow = arrow;
	}
	public int getX() {
		return _x;
	}
	public void setX(int x) {
		this._x = x;
	}
	public int getY() {
		return _y;
	}
	public void setY(int y) {
		this._y = y;
	}
	public cellStatus getCellStatus() {
		return _cellStatus;
	}
	public void setCellStatus(cellStatus cellStatus) {
		this._cellStatus = cellStatus;
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
