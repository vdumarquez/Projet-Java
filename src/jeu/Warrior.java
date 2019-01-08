package jeu;



public class Warrior extends Characters {
	public Warrior()  {
		dir = null;
		x = 1;
		y = 1;
		this.setImage("WarriorArUp.png");
		v = 300;
		nbl=3;
		p=new Gun();
	}
}
