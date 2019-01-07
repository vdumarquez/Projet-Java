package jeu;

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
			if(Game.b[0].x==Game.c1.x) {
				if(Game.b[0].y+1==Game.c1.y || Game.b[0].y-1==Game.c1.y) {
					Game.c1.nbl--;
				}
			}else if(Game.b[0].y==Game.c1.y) {
				if(Game.b[0].x+1==Game.c1.x || Game.b[0].x-1==Game.c1.x) {
					Game.c1.nbl--;
				}
			}
			
			switch(ra) {
			case 0:
				if (Game.ma.lvl[Game.b[0].y - 1][Game.b[0].x] == 48) {
					Game.ma.lvl[Game.b[0].y - 1][Game.b[0].x] = 52;
					Game.ma.lvl[Game.b[0].y][Game.b[0].x] = 48;
					Game.b[0].y--;
				}
				break;
			case 1:
				if (Game.ma.lvl[Game.b[0].y + 1][Game.b[0].x] == 48) {
					Game.ma.lvl[Game.b[0].y + 1][Game.b[0].x] = 52;
					Game.ma.lvl[Game.b[0].y][Game.b[0].x] = 48;
					Game.b[0].y++;
				}
				break;
			case 2:
				if (Game.ma.lvl[Game.b[0].y][Game.b[0].x - 1] == 48) {
					Game.ma.lvl[Game.b[0].y][Game.b[0].x - 1] = 52;
					Game.ma.lvl[Game.b[0].y][Game.b[0].x] = 48;
					Game.b[0].x--;
				}
				break;
			case 3:
				if (Game.ma.lvl[Game.b[0].y][Game.b[0].x + 1] == 48) {
					Game.ma.lvl[Game.b[0].y][Game.b[0].x + 1] = 52;
					Game.ma.lvl[Game.b[0].y][Game.b[0].x] = 48;
					Game.b[0].x++;
				}
				break;
			default:
				break;
			}
			ra=5;
			try {
				Thread.sleep(Game.b[0].v);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Game.w.pan.repaint();
		}
	}
}
