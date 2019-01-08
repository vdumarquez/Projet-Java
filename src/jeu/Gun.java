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
		thp= new ThPower();
		//thp.start();
	}

	@Override
	void Active() {
		// TODO Auto-generated method stub
		String dir;
		int x,y;
		x=Game.c1.x;
		y=Game.c1.y;
		dir=Power.direction;
		for(int i=0;i<Game.c1.p.d;i++) {
			if(Game.ma.lvl[y][x]==51)
				Game.ma.lvl[y][x]=48;
			switch(dir) {
			case "HAUT":
				y--;
				break;
			case "BAS":
				y++;
				break;
			case "GAUCHE":
				x--;
				break;
			case "DROITE":
				x++;
				break;
			default:
				break;
			}
			if(Game.ma.lvl[y][x]==48)
				Game.ma.lvl[y][x]=51;
			else if(Game.ma.lvl[y][x]>51) {
				Game.b[Game.ma.lvl[y][x]-52].nbl=Game.b[Game.ma.lvl[y][x]-52].nbl-Game.c1.p.F;
				break;
			}else {
				break;
			}
			Game.w.pan.repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Game.ma.lvl[y][x]==51)
			Game.ma.lvl[y][x]=48;
		Game.w.pan.repaint();
	}

	
}
