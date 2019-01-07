package jeu;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;

public class Window extends JFrame {
	protected Panel pan = new Panel();
	protected KEVENT key = new KEVENT();

	public Window() {
		this.setTitle("GAME");
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setRootPane(pan);
		this.setVisible(true);
		this.addKeyListener(key);
	}
}
