package dawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Circle {
	private Point centre;
	private int rayon;
	public Circle(int rayon) {
		this.rayon=rayon;
	}
	public void setCentre(Point c){
		this.centre=c;
	}
	public int getRayon() {
		return rayon;
	}
	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
	public Point getCentre(){
		return this.centre;
	}
	public int getWidth(){
		return this.rayon*2;
	}
	public int getHeight(){
		return this.rayon*2;
	}
	public void draw(Graphics g){
		Graphics2D g2d=(Graphics2D) g;
		Ellipse2D.Double circle=new Ellipse2D.Double(this.getCentre().getX(), this.getCentre().getY(), this.getWidth(), this.getHeight());
		g2d.setColor(Color.white);
		g2d.draw(circle);
	}
	
	
}
