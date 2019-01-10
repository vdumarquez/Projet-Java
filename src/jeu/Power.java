package jeu;




import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Power {
	protected Image I;
	protected Image IF;
	protected int F;
	static protected Deplacement direction;
	protected int d;
	protected int x;
	protected int y;
	protected long v;
	public Power(Character c) {
		if(c==Character.WPISTOL) {
			try {
				I = ImageIO.read(new File("Pistol.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			direction=null;
			F=1;
			d=4;
			v=100;
		}else if(c==Character.WAR) {
			try {
				I = ImageIO.read(new File("LanceFlamme.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			direction=null;
			F=1;
			d=3;
			v=50;
		}
	}
	protected void Active() {
		// TODO Auto-generated method stub
		int x_,y_;
		x_=x;
		y_=y;
		if(Game.count<d) {
			Game.count++;

			try {
				switch(direction) {
				case HAUT:
					IF=ImageIO.read(new File("BullletUp.png"));
					y_--;
					break;
				case BAS:
					IF=ImageIO.read(new File("BullletDown.png"));
					y_++;
					break;
				case GAUCHE:
					IF=ImageIO.read(new File("BullletLeft.png"));
					x_--;
					break;
				case DROITE:
					IF=ImageIO.read(new File("BullletRight.png"));
					x_++;
					break;
				default:
					break;
				}
			}catch(IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Map.lvl[y_][x_]==EMap.EMPTY) {
				Map.lvl[y_][x_]=EMap.POWER;
				if(Map.lvl[y][x]==EMap.POWER)
					Map.lvl[y][x]=EMap.EMPTY;
				x=x_;
				y=y_;
			}
			else if(Map.lvl[y_][x_]==EMap.BOT) {
				int i;
				for(i=0;i<Game.b.length;i++) {
					if(x_==Game.b[i].x&&y_==Game.b[i].y)
						break;
				}
				Game.b[i].nbl=Game.b[i].nbl-Game.c1.p.F;
				if(Map.lvl[y][x]==EMap.POWER)
					Map.lvl[y][x]=EMap.EMPTY;
				Game.count=0;
				Game.po=false;
			}

		}else {
			if(Map.lvl[y][x]==EMap.POWER)
				Map.lvl[y][x]=EMap.EMPTY;
			Game.po=false;
			Game.count=0;
		}
	}
}
