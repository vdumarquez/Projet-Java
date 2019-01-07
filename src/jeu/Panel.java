package jeu;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class Panel extends JRootPane {
	protected Menu layered = new Menu();
	protected PMap map = new PMap();
	protected MenuBar bar = new MenuBar();

	public Panel() {
		this.setLayeredPane(layered);
		this.setContentPane(map);
		this.setMenuBar(bar);
		for(int i=0;i<Game.c1.p.length;i++) {
			if(Game.c1.p[i]!=null)
				this.add(Game.c1.p[i].b);
		}
	}
}
