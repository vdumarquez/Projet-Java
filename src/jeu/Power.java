package jeu;




import java.awt.Image;


public abstract class Power {
	protected Image I;
	protected int F;
	static protected Deplacement direction;
	protected int d;
	protected int x;
	protected int y;
	abstract void Active();
}
