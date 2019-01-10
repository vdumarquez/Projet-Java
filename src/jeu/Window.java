package jeu;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;

public class Window extends JFrame {
	protected PMap pan = new PMap();
	protected KEVENT key = new KEVENT();

	public Window() {
		this.setTitle("MAZE WARRIOR");
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pan);
		this.setVisible(true);
		this.addKeyListener(key);
	}
}
