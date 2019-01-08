package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KEVENT implements KeyListener {
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
			Power.direction=Deplacement.HAUT;
			break;
		case KeyEvent.VK_S:
			Game.c1.dir = Deplacement.BAS;
			Power.direction=Deplacement.BAS;
			break;
		case KeyEvent.VK_Q:
			Game.c1.dir = Deplacement.GAUCHE;
			Power.direction=Deplacement.GAUCHE;
			break;
		case KeyEvent.VK_D:
			Game.c1.dir = Deplacement.DROITE;
			Power.direction=Deplacement.DROITE;
			break;
		case KeyEvent.VK_J:

		default:
			break;
		}
	}
}
