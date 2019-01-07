package jeu;

import java.io.IOException;

public class Warrior extends Characters {
	public Warrior()  {
		super();
		x = 1;
		y = 1;
		this.setImage("TEST_PERSO.jpg");
		v = 300;
		nbl=3;
		th = new ThCharacters();
		th.start();
		
	}
}
