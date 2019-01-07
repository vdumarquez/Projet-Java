package jeu;


import javax.swing.JLabel;
import javax.swing.JRootPane;

public class Panel extends JRootPane {
	protected Menu layered = new Menu();
	protected PMap map = new PMap();
	protected MenuBar bar = new MenuBar();
	public Panel() {
		this.setLayeredPane(layered);
		this.setContentPane(map);
		this.setMenuBar(bar);
		
	}
}
