package dawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.xml.*;
import dawing.*;
public class DynamicShapes extends JPanel{
	private	List<Object> shapes=new ArrayList<>();
	private JPanel panmenu=new JPanel();
	
	
	
	
	public DynamicShapes(){
		
		JButton rectangle=new JButton("RECTANGLE");
		JButton circle=new JButton("CIRCLE");
		JButton line=new JButton("LINE");
		JButton convertToXmlBtn=new JButton("convertToXml");
		JButton readXml=new JButton("readFromXml");
		panmenu.add(rectangle, JPanel.LEFT_ALIGNMENT);
		panmenu.add(readXml, JPanel.LEFT_ALIGNMENT);
		panmenu.add(circle, JPanel.LEFT_ALIGNMENT);
		panmenu.add(line, JPanel.LEFT_ALIGNMENT);
		panmenu.add(convertToXmlBtn, JPanel.LEFT_ALIGNMENT);
		
		
		rectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mu=JOptionPane.showInputDialog(null,"entrez le margeUp","",JOptionPane.PLAIN_MESSAGE);
				int mU=Integer.parseInt(mu);
				String ml=JOptionPane.showInputDialog(null,"entrez le margeLeft","",JOptionPane.PLAIN_MESSAGE);
				int mL=Integer.parseInt(ml);
				String ht=JOptionPane.showInputDialog(null,"enter height","",JOptionPane.PLAIN_MESSAGE);
				int hT=Integer.parseInt(ht);
				String wh=JOptionPane.showInputDialog(null,"enter width","",JOptionPane.PLAIN_MESSAGE);
				int wH=Integer.parseInt(wh);
				
				Rectangle r=new Rectangle( hT, wH);
				r.setMarge(mU, mL);
				addRectangle(r);
				r.toString();
			} 
		});
		readXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {

				    	File fXmlFile = new File("C:\\Users\\abdoB\\Desktop\\exemple.xml");
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(fXmlFile);

					doc.getDocumentElement().normalize();

					System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

					
					
					
					//Rectangle
					NodeList rList = doc.getElementsByTagName("Rectangle");
					System.out.println("----------------------------");
					for (int i = 0; i < rList.getLength(); i++) {

						Node rNode = rList.item(i);
						System.out.println("\nCurrent Element :" + rNode.getNodeName());
						if (rNode.getNodeType() == Node.ELEMENT_NODE) {

							Element eElement = (Element) rNode;

							String margeUp=eElement.getElementsByTagName("marge").item(0).getAttributes().item(0).getNodeValue();
							int mu=Integer.parseInt(margeUp);
							
							String margeLeft=eElement.getElementsByTagName("marge").item(0).getAttributes().item(1).getNodeValue();
							int ml=Integer.parseInt(margeLeft);
							
							String height=eElement.getElementsByTagName("height").item(0).getTextContent();
							int he=Integer.parseInt(height);
							
							String width=eElement.getElementsByTagName("width").item(0).getTextContent();
							int wi=Integer.parseInt(width);
							Rectangle r=new Rectangle(he,wi);
							r.setMarge(mu, ml);
							System.out.println(r.getHeight()+""+r.getWidth()+""+r.getMarge().getX()+""+r.getMarge().getY());
							shapes.add(r);
							repaint();
							
						}
					}
					
					//Line
					NodeList lList = doc.getElementsByTagName("Ligne");
					System.out.println("----------------------------");
					for (int i = 0; i < lList.getLength(); i++) {

						Node lNode = lList.item(i);
						System.out.println("\nCurrent Element :" + lNode.getNodeName());
						if (lNode.getNodeType() == Node.ELEMENT_NODE) {

							Element eElement = (Element) lNode;

							String ax=eElement.getElementsByTagName("pointA").item(0).getAttributes().item(0).getNodeValue();
							int aX=Integer.parseInt(ax);
							
							String ay=eElement.getElementsByTagName("pointA").item(0).getAttributes().item(1).getNodeValue();
							int aY=Integer.parseInt(ay);

							String bx=eElement.getElementsByTagName("pointB").item(0).getTextContent();
							int bX=Integer.parseInt(bx);

							String by=eElement.getElementsByTagName("pointB").item(0).getTextContent();
							int bY=Integer.parseInt(by);
							Point pa=new Point(aX, aY);
							Point pb=new Point(bX, bY);
							Line l=new Line(pa, pb);
							shapes.add(l);
							repaint();
							
						}
					}
					
					//Cercle
					NodeList cList = doc.getElementsByTagName("Cercle");
					System.out.println("----------------------------");
					for (int i = 0; i < cList.getLength(); i++) {

						Node cNode = cList.item(i);
						System.out.println("\nCurrent Element :" + cNode.getNodeName());
						if (cNode.getNodeType() == Node.ELEMENT_NODE) {

							Element eElement = (Element) cNode;

							String x=eElement.getElementsByTagName("centre").item(0).getAttributes().item(0).getNodeValue();
							int xx=Integer.parseInt(x);
							
							String y=eElement.getElementsByTagName("centre").item(0).getAttributes().item(1).getNodeValue();
							int yy=Integer.parseInt(y);
							
							String ray=eElement.getElementsByTagName("rayon").item(0).getTextContent();
							int rayon=Integer.parseInt(ray);
							
							Circle c=new Circle(rayon);
							Point p=new Point(xx, yy);
							c.setCentre(p);
							shapes.add(c);
							repaint();
						}
					}
					
					
					
				 }catch (Exception ex) {
						ex.printStackTrace();
				    }
				 }
		});
		
		
		circle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cx=JOptionPane.showInputDialog(null,"entrez le X du centre","",JOptionPane.PLAIN_MESSAGE);
				int cX=Integer.parseInt(cx);
				String cy=JOptionPane.showInputDialog(null,"entrez le Y du centre","",JOptionPane.PLAIN_MESSAGE);
				int cY=Integer.parseInt(cy);
				String rayon=JOptionPane.showInputDialog(null,"entrez le rayon du cercle","",JOptionPane.PLAIN_MESSAGE);
				int ray=Integer.parseInt(rayon);
				
				Circle c=new Circle(ray);
				c.toString();
				c.setCentre(new Point(cX,cY));
				addCircle(c);
				
			} 
		});
		line.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point pa=new Point();
				Point pb=new Point();
				String p1x=JOptionPane.showInputDialog(null,"entrez le X du point 1","",JOptionPane.PLAIN_MESSAGE);
				pa.setX(Integer.parseInt(p1x));
				String p1y=JOptionPane.showInputDialog(null,"entrez le Y du point 1","",JOptionPane.PLAIN_MESSAGE);
				pa.setY(Integer.parseInt(p1y));
				String p2x=JOptionPane.showInputDialog(null,"entrez le X du point 2","",JOptionPane.PLAIN_MESSAGE);
				pb.setX(Integer.parseInt(p2x));
				String p2y=JOptionPane.showInputDialog(null,"entrez le Y du point 2","",JOptionPane.PLAIN_MESSAGE);
				pb.setY(Integer.parseInt(p2y));
				Line l=new Line(pa, pb);
				addLine(l);
				l.toString();
			} 
		});
		
		
		convertToXmlBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// convert forms to xml
				XmlWriter xmlWriter=new XmlWriter();
				try {
					xmlWriter.convert("C:\\Users\\abdoB\\Desktop\\exemple.xml",shapes);
					JOptionPane.showMessageDialog(null, "fichier xml créé correctement",
							"ok", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "erreur de conversion en xmls",
							"erreur", JOptionPane.ERROR_MESSAGE);
				}
					
				
				
			}
		});
		
		
		
		add(panmenu,BorderLayout.NORTH);
		setBackground(Color.gray);
		setPreferredSize(new Dimension(600, 600));
		
	}
	
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for(Object s:shapes){
			if(s instanceof Circle){
				((Circle)s).draw(g);
			}else if(s instanceof Rectangle){
				((Rectangle)s).draw(g);
				
			}else if(s instanceof Line){
				((Line)s).draw(g);
			}
		}
	}
	
	public void addCircle(Circle c){
		shapes.add(c);
		repaint();		
		
	}
	public void addRectangle(Rectangle r){
		shapes.add(r);
		repaint();
		
	}
	public void addLine(Line l){
		shapes.add(l);
		repaint();
	}
	public static void main(String[] args){
		
		JFrame frame=new JFrame();
		frame.add(new DynamicShapes());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
