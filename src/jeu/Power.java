package jeu;




import java.awt.Image;


public abstract class Power {
	protected Image I;
	protected int F;
	static protected String direction;
	protected int d;
	Thread thp;
	abstract void Active();
}
