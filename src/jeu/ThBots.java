package jeu;

import java.util.Random;

public class ThBots extends Thread {
	public void run() {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true) {
			int ra =(int)(Math.random()*3);
			if(Game.b1.x==Game.c1.x) {
				if(Game.b1.y+1==Game.c1.y || Game.b1.y-1==Game.c1.y) {
					Game.c1.nbl--;
				}
			}else if(Game.b1.y==Game.c1.y) {
				if(Game.b1.x+1==Game.c1.x || Game.b1.x-1==Game.c1.x) {
					Game.c1.nbl--;
				}
			}
			
			switch(ra) {
			case 0:
				if (Game.ma.lvl[Game.b1.y - 1][Game.b1.x] == 48) {
					Game.ma.lvl[Game.b1.y - 1][Game.b1.x] = 50;
					Game.ma.lvl[Game.b1.y][Game.b1.x] = 48;
					Game.b1.y--;
				}
				break;
			case 1:
				if (Game.ma.lvl[Game.b1.y + 1][Game.b1.x] == 48) {
					Game.ma.lvl[Game.b1.y + 1][Game.b1.x] = 50;
					Game.ma.lvl[Game.b1.y][Game.b1.x] = 48;
					Game.b1.y++;
				}
				break;
			case 2:
				if (Game.ma.lvl[Game.b1.y][Game.b1.x - 1] == 48) {
					Game.ma.lvl[Game.b1.y][Game.b1.x - 1] = 50;
					Game.ma.lvl[Game.b1.y][Game.b1.x] = 48;
					Game.b1.x--;
				}
				break;
			case 3:
				if (Game.ma.lvl[Game.b1.y][Game.b1.x + 1] == 48) {
					Game.ma.lvl[Game.b1.y][Game.b1.x + 1] = 50;
					Game.ma.lvl[Game.b1.y][Game.b1.x] = 48;
					Game.b1.x++;
				}
				break;
			default:
				break;
			}
			ra=5;
			try {
				Thread.sleep(Game.b1.v);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Game.w.pan.repaint();
		}
	}
}
