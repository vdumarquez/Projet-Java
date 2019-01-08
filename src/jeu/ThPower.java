package jeu;

public class ThPower extends Thread {
public void run() {
	while(true) {
		if(Game.c1.p.t==1) {
			Active();
			Game.c1.p.t=0;
		}
	}
}

private void Active_() {
	int j;
	if(Game.ma.lvl[Game.c1.p.y][Game.c1.p.x]!=49) {

		for(j=0;j<Game.b.length;j++) {
			if(Game.ma.lvl[Game.c1.p.y][Game.c1.p.x]==Game.ma.lvl[Game.b[j].y][Game.b[j].x]) {
				Game.b[j].nbl=Game.b[j].nbl-Game.c1.p.F;
				break;
			}
		}
		if(j==Game.b.length) {
			Game.ma.lvl[Game.c1.p.y][Game.c1.p.x]=51;
			Game.w.pan.repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Game.ma.lvl[Game.c1.p.y][Game.c1.p.x]=48;
		}
	}
}

public void Active() {
	switch(Game.c1.p.direction) {
	case "HAUT":
		Game.c1.p.x=Game.c1.x;
		Game.c1.p.y=Game.c1.y-1;
		for(int i=0;i<4;i++) {
			Active_();
			if(Game.ma.lvl[Game.c1.p.y][Game.c1.p.x]!=49)
				Game.c1.p.y=Game.c1.p.y-1;
		}
		break;
	case "BAS":
		Game.c1.p.x=Game.c1.x;
		Game.c1.p.y=Game.c1.y+1;
		for(int i=0;i<4;i++) {
			Active_();
			if(Game.ma.lvl[Game.c1.p.y][Game.c1.p.x]!=49)
				Game.c1.p.y=Game.c1.p.y+1;
		}
		break;
	case "GAUCHE":
		Game.c1.p.x=Game.c1.x-1;
		Game.c1.p.y=Game.c1.y;
		for(int i=0;i<4;i++) {
			Active_();
			if(Game.ma.lvl[Game.c1.p.y][Game.c1.p.x]!=49)
				Game.c1.p.x=Game.c1.p.x-1;
		}
		break;
	case "DROITE":
		Game.c1.p.x=Game.c1.x-1;
		Game.c1.p.y=Game.c1.y;
		for(int i=0;i<4;i++) {
			Active_();
			if(Game.ma.lvl[Game.c1.p.y][Game.c1.p.x]!=49)
				Game.c1.p.x=Game.c1.p.x+1;
		}
		break;
	default:
		break;
	}
}
}
