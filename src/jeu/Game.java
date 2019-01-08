package jeu;

public class Game {
	protected static Characters c1;
	protected static Characters b[];
	protected static Map ma;
	protected static Window w;
	
	private static void ThCharacters() {
		while(true) {

			if (Game.c1.dir != null) {
				switch (Game.c1.dir) {
				case "HAUT":
					Game.c1.setImage("WarriorPistolUp.png");
					if (Game.ma.lvl[Game.c1.y - 1][Game.c1.x] == 48) {
						Game.ma.lvl[Game.c1.y - 1][Game.c1.x] = 50;
						Game.ma.lvl[Game.c1.y][Game.c1.x] = 48;
						Game.c1.y--;
					}
					break;
				case "BAS":
					Game.c1.setImage("WarriorPistolDown.png");
					if (Game.ma.lvl[Game.c1.y + 1][Game.c1.x] == 48) {
						Game.ma.lvl[Game.c1.y + 1][Game.c1.x] = 50;
						Game.ma.lvl[Game.c1.y][Game.c1.x] = 48;
						Game.c1.y++;
					}
					break;
				case "GAUCHE":
					Game.c1.setImage("WarriorPistolLeft.png");
					if (Game.ma.lvl[Game.c1.y][Game.c1.x - 1] == 48) {
						Game.ma.lvl[Game.c1.y][Game.c1.x - 1] = 50;
						Game.ma.lvl[Game.c1.y][Game.c1.x] = 48;
						Game.c1.x--;
					}
					break;
				case "DROITE":
					Game.c1.setImage("WarriorPistolRight.png");
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

	public static void main(String[] args) {
		c1 = new Warrior();
		b=new Bots[1];
		b[0]=new Bots();
		ma = new Map();
		w = new Window();
		ThCharacters();
	}
}
