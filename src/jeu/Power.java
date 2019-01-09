package jeu;




import java.awt.Image;


public abstract class Power {
	protected Image I;
	protected Image IF;
	protected int F;
	static protected Deplacement direction;
	protected int d;
	protected int x;
	protected int y;
	protected long v;
	abstract void Active();
}
