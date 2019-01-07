package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KEVENT implements KeyListener {
	public void keyTyped(KeyEvent e) {
		// Invoked when a key has been typed.
		switch (e.getKeyCode()) {

		case KeyEvent.VK_Z:
			Game.c1.dir = "HAUT";
			Power.direction="HAUT";
			break;
		case KeyEvent.VK_S:
			Game.c1.dir = "BAS";
			Power.direction="BAS";
			break;
		case KeyEvent.VK_Q:
			Game.c1.dir = "GAUCHE";
			Power.direction="GAUCHE";
			break;
		case KeyEvent.VK_D:
			Game.c1.dir = "DROITE";
			Power.direction="DROITE";
			break;
		case KeyEvent.VK_J:
			Game.c1.p.t=1;
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
			Power.direction="HAUT";
			break;
		case KeyEvent.VK_S:
			Game.c1.dir = "BAS";
			Power.direction="BAS";
			break;
		case KeyEvent.VK_Q:
			Game.c1.dir = "GAUCHE";
			Power.direction="GAUCHE";
			break;
		case KeyEvent.VK_D:
			Game.c1.dir = "DROITE";
			Power.direction="DROITE";
			break;
		case KeyEvent.VK_J:
			Game.c1.p.t=1;
			break;
		default:
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		// Invoked when a key has been released.
		
	}

}
