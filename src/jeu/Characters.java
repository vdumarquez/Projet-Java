package jeu;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Characters {
	protected int x;
	protected int y;
	protected int nbl;
	protected int weight;
	protected Power[] p= new Power[4];
	protected Image I;
	protected String dir;
	protected long v;
	Thread th;

	public Characters(){
		dir = null;
		p[0]=new Power();
		p[0].c="U";
	}

	public void setImage(String s) {
		try {
			I = ImageIO.read(new File(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
