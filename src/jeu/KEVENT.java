package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KEVENT implements KeyListener {
	private Deplacement dir=Deplacement.HAUT;
	public void keyTyped(KeyEvent e) {
		// Invoked when a key has been typed.
		depl(e);
	}

	public void keyPressed(KeyEvent e) {
		// Invoked when a key has been pressed.
		depl(e);
	}

	public void keyReleased(KeyEvent e) {
		// Invoked when a key has been released.

	}

	public void depl(KeyEvent e) {
		if(Game.c1!=null) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_P:
				if(Game.c1.Isalive==Boolean.FALSE) {
					Game.c1=null;
					Game.score=0;
					Map.niv=0;
					Map.lvl=Map.LFile();
					for(int i=0;i<Game.b.length;i++) {
						Game.b[i].Init(Game.b[i].ch);
					}
				}else
					if(Game.start)
						Game.start=Boolean.FALSE;
					else
						Game.start=Boolean.TRUE;
				break;
			case KeyEvent.VK_J:
				if(Game.po==false) {
					Power.direction=dir;
					Game.c1.p.x=Game.c1.x;
					Game.c1.p.y=Game.c1.y;
					Game.po=true;
				}
				break;
			case KeyEvent.VK_Z:
				Game.c1.dir=Deplacement.HAUT;
				dir=Deplacement.HAUT;
				break;
			case KeyEvent.VK_S:
				Game.c1.dir = Deplacement.BAS;
				dir=Deplacement.BAS;
				break;
			case KeyEvent.VK_Q:
				Game.c1.dir = Deplacement.GAUCHE;
				dir=Deplacement.GAUCHE;
				break;
			case KeyEvent.VK_D:
				Game.c1.dir = Deplacement.DROITE;
				dir=Deplacement.DROITE;
				break;


			default:
				break;
			}
		}else {
			switch (e.getKeyCode()) {

			case KeyEvent.VK_1:
				Game.c1= new Characters(Character.WAR);
				break;
			case KeyEvent.VK_2:
				Game.c1= new Characters(Character.WFIRE);
				break;
			case KeyEvent.VK_3:
				Game.c1= new Characters(Character.WPISTOL);
				break;
			default:
				break;
			}
		}

	}
}
