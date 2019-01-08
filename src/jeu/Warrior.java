package jeu;



public class Warrior extends Characters {
	public Warrior()  {
		dir = null;
		x = 1;
		y = 1;
		this.setImage("WarriorPistolUp.png");
		v = 300;
		nbl=3;
		p=new Gun();
	}
}
