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
	protected Power p;
	protected Image I;
	protected Deplacement dir;
	protected long v;
	Thread th;

	public Characters(Character c){
		if(c==Character.PISTOL)
			WarriorPistol();
		if(c==Character.BOT)
			Bots();
	}

	public void move() {
		int x_,y_;
		if(dir!=Deplacement.IMMOBILE) {
			x_=x;
			y_=y;
			switch (dir) {
			case HAUT:
				setImage("WarriorPistolUp.png");
				y_--;
				break;
			case BAS:
				setImage("WarriorPistolDown.png");
				y_++;

				break;
			case GAUCHE:
				setImage("WarriorPistolLeft.png");
				x_--;
				break;
			case DROITE:
				setImage("WarriorPistolRight.png");
				x_++;
				break;
			default:
				break;
			}
			if (Game.ma.lvl[y_][x_] == 48) {
				Game.ma.lvl[y_][x_] = 50;
				Game.ma.lvl[y_][x_] = 48;
				x=x_;
				y=y_;
			}
			dir=Deplacement.IMMOBILE;
		}
	}

	private void WarriorPistol()  {
		dir = null;
		x = 1;
		y = 1;
		setImage("WarriorPistolUp.png");
		v = 300;
		nbl=3;
		p=new Gun();
	}

	private void Bots() {
		x = 14;
		y = 12;
		setImage("ZombiPunkUp.png");
		v = 500;
		nbl=3;
		th = new ThBots();
		th.start();
	}

	public void setImage(String s) {
		try {
			I = ImageIO.read(new File(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
