package jeu;



import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javafx.scene.paint.Color;

//BOUTON POUVOIR
public class Power {
	protected Image I;
	protected int F;
	protected String c;
	public Power() {
		try {
			I = ImageIO.read(new File("Sword_power.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    F=1;
	} 
	
	
}
