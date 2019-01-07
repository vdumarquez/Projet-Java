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
	protected Icon I;
	protected int F;
	protected JButton b;
	public Power() {
		I = new ImageIcon("Sword_power.jpg");
		b=new JButton(I);
	    b.setBounds((int) (0.05 * Game.w.pan.layered.getWidth()),(int) (0.93 *  Game.w.pan.layered.getHeight()),
	    		(int)Game.w.pan.layered.getWidth()/15, (int)Game.w.pan.layered.getHeight()/15 );
	    F=1;
	} 
	
	
}
