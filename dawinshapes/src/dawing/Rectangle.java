package dawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class Rectangle {

	public Point marge;
	private int height;
	private int width;
	public Rectangle(int height,int width) {
		this.marge=new Point(0,0);
		this.height=height;
		this.width=width;
	}
	
	public void setMarge(int x,int y){
		this.marge.setX(x);
		this.marge.setY(y);
	}
	public Point getMarge(){
		return this.marge;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public void draw(Graphics g){
		
		Graphics2D g2d=(Graphics2D)g;
		g2d.setColor(Color.white);
		g2d.drawRect(this.marge.getX(), this.marge.getY(), this.getWidth(),this.getHeight() );
		
	}
}
