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
	}

	private void Active_() {
		int j;
		if(Game.ma.lvl[y][x]!=49) {

			for(j=0;j<Game.b.length;j++) {
				if(Game.ma.lvl[y][x]==Game.ma.lvl[Game.b[j].y][Game.b[j].x]) {
					Game.b[j].nbl=Game.b[j].nbl-F;
					break;
				}
			}
			if(j==Game.b.length) {
				Game.ma.lvl[y][x]=51;
				Game.w.pan.repaint();
				Game.ma.lvl[y][x]=48;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void Active() {
		// TODO Auto-generated method stub
		try {
			Game.c1.I=ImageIO.read(new File("TEST_PERSO_POWER.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(direction) {
		case "HAUT":
			x=Game.c1.x;
			y=Game.c1.y+1;
			for(int i=0;i<4;i++) {
				Active_();
				if(Game.ma.lvl[y][x]!=49)
					y=y-1;
			}
			break;
		case "BAS":
			x=Game.c1.x;
			y=Game.c1.y-1;
			for(int i=0;i<4;i++) {
				Active_();
				if(Game.ma.lvl[y][x]!=49)
					y=y+1;
			}
			break;
		case "GAUCHE":
			x=Game.c1.x-1;
			y=Game.c1.y;
			for(int i=0;i<4;i++) {
				Active_();
				if(Game.ma.lvl[y][x]!=49)
					x=x-1;
			}
			break;
		case "DROITE":
			x=Game.c1.x-1;
			y=Game.c1.y;
			for(int i=0;i<4;i++) {
				Active_();
				if(Game.ma.lvl[y][x]!=49)
					x=x+1;
			}
			break;
		default:
			break;
		}
	}
}
