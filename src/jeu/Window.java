package jeu;


import javax.swing.JFrame;


public class Window extends JFrame {
	protected PMap pan = new PMap();
	protected KEVENT key = new KEVENT();
	private Thread ThSound;
    

	public Window() {
		this.setTitle("MAZE WARRIOR");
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pan);
		this.setVisible(true);
		this.addKeyListener(key);
		ThSound = new Sound();
		ThSound.start();
	}
}
