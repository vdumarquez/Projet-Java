package jeu;

public class ThCharacters extends Thread {
	public void run() {
		while (true) {
			if (Game.c1.dir != null) {
				switch (Game.c1.dir) {
				case "HAUT":
					Game.c1.setImage("WarriorFireUp.png");
					if (Game.ma.lvl[Game.c1.y - 1][Game.c1.x] == 48) {
						Game.ma.lvl[Game.c1.y - 1][Game.c1.x] = 50;
						Game.ma.lvl[Game.c1.y][Game.c1.x] = 48;
						Game.c1.y--;
					}
					break;
				case "BAS":
					Game.c1.setImage("WarriorFireDown.png");
					if (Game.ma.lvl[Game.c1.y + 1][Game.c1.x] == 48) {
						Game.ma.lvl[Game.c1.y + 1][Game.c1.x] = 50;
						Game.ma.lvl[Game.c1.y][Game.c1.x] = 48;
						Game.c1.y++;
					}
					break;
				case "GAUCHE":
					Game.c1.setImage("WarriorFireLeft.png");
					if (Game.ma.lvl[Game.c1.y][Game.c1.x - 1] == 48) {
						Game.ma.lvl[Game.c1.y][Game.c1.x - 1] = 50;
						Game.ma.lvl[Game.c1.y][Game.c1.x] = 48;
						Game.c1.x--;
					}
					break;
				case "DROITE":
					Game.c1.setImage("WarriorFireRight.png");
					if (Game.ma.lvl[Game.c1.y][Game.c1.x + 1] == 48) {
						Game.ma.lvl[Game.c1.y][Game.c1.x + 1] = 50;
						Game.ma.lvl[Game.c1.y][Game.c1.x] = 48;
						Game.c1.x++;
					}
					break;
				default:
					break;
				}
			}
			Game.c1.dir = null;
			Game.w.pan.repaint();
			try {
				Thread.sleep(Game.c1.v);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
