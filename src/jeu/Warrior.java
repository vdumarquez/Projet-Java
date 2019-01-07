package jeu;



public class Warrior extends Characters {
	public Warrior()  {
		dir = null;
		x = 1;
		y = 1;
		this.setImage("WarriorFireUp.png");
		v = 300;
		nbl=3;
		th = new ThCharacters();
		th.start();
		p=new Gun();
	}
}
