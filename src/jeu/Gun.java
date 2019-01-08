package jeu;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Gun extends Power {
	public Gun() {
		try {
			I = ImageIO.read(new File("Sword_power.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		direction=null;
		F=1;
		d=4;
	}

	@Override
	void Active() {
		// TODO Auto-generated method stub
		int x_,y_,count=0;
		x_=x;
		y_=y;
		if(count<d) {
			count++;
			if(Game.ma.lvl[y_][x_]==EMap.POWER)
				Game.ma.lvl[y_][x_]=EMap.EMPTY;
			switch(direction) {
			case HAUT:
				y_--;
				break;
			case BAS:
				y_++;
				break;
			case GAUCHE:
				x_--;
				break;
			case DROITE:
				x_++;
				break;
			default:
				break;
			}
			if(Game.ma.lvl[y_][x_]==EMap.EMPTY) {
				Game.ma.lvl[y_][x_]=EMap.POWER;
				x=x_;
				y=y_;
			}
			else if(Game.ma.lvl[y_][x_]==EMap.BOT) {
				int i;
				for(i=0;i<Game.b.length;i++) {
					if(x_==Game.b[i].x&&y_==Game.b[i].y)
						break;
				}
				Game.b[i].nbl=Game.b[i].nbl-Game.c1.p.F;
				x=Game.c1.x;
				y=Game.c1.y;
				count=d;
			}
			
		}else if(Game.ma.lvl[y_][x_]==EMap.POWER){
			Game.ma.lvl[y_][x_]=EMap.EMPTY;
			x=Game.c1.x;
			y=Game.c1.x;
		}
	}

	
}
