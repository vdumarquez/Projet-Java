package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KEVENT implements KeyListener {
	public void keyTyped(KeyEvent e) {
		// Invoked when a key has been typed.
		switch (e.getKeyCode()) {

		case KeyEvent.VK_Z:
			Game.c1.dir = "HAUT";
			break;
		case KeyEvent.VK_S:
			Game.c1.dir = "BAS";
			break;
		case KeyEvent.VK_Q:
			Game.c1.dir = "GAUCHE";
			break;
		case KeyEvent.VK_D:
			Game.c1.dir = "DROITE";
			break;
		default:
			break;
		}
	}

	public void keyPressed(KeyEvent e) {
		// Invoked when a key has been pressed.
		switch (e.getKeyCode()) {

		case KeyEvent.VK_Z:
			Game.c1.dir = "HAUT";
			break;
		case KeyEvent.VK_S:
			Game.c1.dir = "BAS";
			break;
		case KeyEvent.VK_Q:
			Game.c1.dir = "GAUCHE";
			break;
		case KeyEvent.VK_D:
			Game.c1.dir = "DROITE";
			break;
		default:
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		// Invoked when a key has been released.
		
	}

}
