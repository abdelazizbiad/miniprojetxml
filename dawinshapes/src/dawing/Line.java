package dawing;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Line {
	private Point pa;
	private Point pb;
	private String id;
	public Line(Point pa, Point pb) {
		this.pa = pa;
		this.pb = pb;
	}
	
	public void draw(Graphics g){
		Graphics2D g2d=(Graphics2D)g;
		g2d.setColor(Color.white);
		g2d.drawLine(this.pa.getX(), this.pa.getY(), this.pb.getX(), this.pb.getY());
		
	}

	@Override
	public String toString() {
		return "Line [pa=" + pa + ", pb=" + pb + ", id=" + id + "]";
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Point getPa() {
		return pa;
	}
	public void setPa(Point pa) {
		this.pa = pa;
	}
	public Point getPb() {
		return pb;
	}
	public void setPb(Point pb) {
		this.pb = pb;
	}

}
