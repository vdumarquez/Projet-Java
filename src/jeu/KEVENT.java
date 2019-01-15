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
		if(Game.IsStart) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_P:
				if(Game.c1.Isalive==Boolean.FALSE) {
					Game.IsStart=Boolean.FALSE;
					Game.CP=null;
					Game.po=Boolean.FALSE;
					Game.score=0;
					Game.Islvl=Boolean.FALSE;
					Game.Iskey=Boolean.FALSE;
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
				if(Game.po==Boolean.FALSE) {
					Power.direction=dir;
					Game.c1.p.x=Game.c1.x;
					Game.c1.p.y=Game.c1.y;
					Game.po=Boolean.TRUE;
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
				Game.CP=Character.WAR;
				
				break;
			case KeyEvent.VK_2:
				Game.CP=Character.WFIRE;
				break;
			case KeyEvent.VK_3:
				Game.CP=Character.WPISTOL;
				break;
			default:
				break;
			}
		}

	}
}
