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
		
		switch (e.getKeyCode()) {

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
		case KeyEvent.VK_J:
			if(Game.po==false) {
				Power.direction=dir;
				Game.c1.p.x=Game.c1.x;
				Game.c1.p.y=Game.c1.y;
				Game.po=true;
			}
		case KeyEvent.VK_P:
			Game.start=true;
			break;
		default:
			break;
		}
		
	}
}
