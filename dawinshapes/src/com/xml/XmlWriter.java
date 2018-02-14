package com.xml;

import javax.xml.parsers.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import dawing.*;

import java.io.File;
import java.util.*;


public class XmlWriter {
	private Document doc;
	public void convert(String pFile,List<Object>shapes){
		try {
			DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
			doc=dBuilder.newDocument();
			
			//root element
			
			Element rootElement=doc.createElement("figures");
			doc.appendChild(rootElement);
			
			
			for(Object s:shapes){
				if(s instanceof Circle){
					//cercle
					Element circle=doc.createElement("circle");
					
					//point centre
					Element centre=doc.createElement("centre");
					centre.setAttribute("X",String.valueOf(((Circle)s).getCentre().getX()));
					centre.setAttribute("Y",String.valueOf(((Circle)s).getCentre().getY()));
					
					//rayon
					Element rayon=doc.createElement("rayon");
					rayon.setTextContent(String.valueOf(((Circle)s).getRayon()));
					
					circle.appendChild(centre);
					circle.appendChild(rayon);
					rootElement.appendChild(circle);
				}else if(s instanceof Rectangle){
					//rectangle
					Element rectangle=doc.createElement("Rectangle");
					
					//la marge up/left
					Element marge=doc.createElement("marge");
					marge.setAttribute("margeUP",String.valueOf(((Rectangle)s).getMarge().getX()));
					marge.setAttribute("margLEFT",String.valueOf(((Rectangle)s).getMarge().getY()));
					
					//hauteur
					Element height=doc.createElement("height");
					height.setTextContent(String.valueOf(((Rectangle)s).getHeight()));
					//longueur
					Element width=doc.createElement("width");
					width.setTextContent(String.valueOf(((Rectangle)s).getWidth()));
					
					rectangle.appendChild(marge);
					rectangle.appendChild(height);
					rectangle.appendChild(width);
					rootElement.appendChild(rectangle);
				}
				
				else if(s instanceof Line){
					//line
					Element ligne=doc.createElement("ligne");
					
					//son point a
					Element pointA=doc.createElement("pointA");
					pointA.setAttribute("x",String.valueOf(((Line)s).getPa().getX()));
					pointA.setAttribute("y",String.valueOf(((Line)s).getPa().getY()));
					
					//son point b
					Element pointB=doc.createElement("pointB");
					pointB.setAttribute("x",String.valueOf(((Line) s).getPb().getX()));
					pointB.setAttribute("y",String.valueOf(((Line) s).getPb().getY()));
					
					ligne.appendChild(pointA);
					ligne.appendChild(pointB);
					
					rootElement.appendChild(ligne);
				}
				
			
				
			}
			//write the content into xml file
			TransformerFactory transformerFactory=TransformerFactory.newInstance();
			Transformer transformer=transformerFactory.newTransformer();
			DOMSource source=new DOMSource(doc);
			StreamResult result=new StreamResult(new File(pFile));
			transformer.transform(source, result);
			
			//output to console for testing
			StreamResult consoleResult=new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}
}
