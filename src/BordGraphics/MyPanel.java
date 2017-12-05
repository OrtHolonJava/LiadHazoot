/**
package BordGraphics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel 
{
	private Img _img;
	public  MyPanel()
	{
		_img = new Img("images\\ססס.jpg", 0, 0, 600, 200);
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		// TODO Auto-generated method stub
		super.paintComponent(g);
		_img.drawImg(g);
	}
}
**/