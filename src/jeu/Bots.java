package jeu;

public class Bots extends Characters {
	public Bots() {
		super();
		x = 14;
		y = 12;
		this.setImage("ZombiPunkUp.png");
		v = 500;
		nbl=3;
		th = new ThBots();
		th.start();
	}
}
