package jeu;



import javax.swing.JRootPane;

public class Panel extends JRootPane {

	protected Menu layered = new Menu();
	protected PMap map = new PMap();
	public Panel() {
		this.setLayeredPane(layered);
		this.setContentPane(map);
	}
}
