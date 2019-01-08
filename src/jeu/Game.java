package jeu;

public class Game {
	protected static Characters c1;
	protected static Characters b[];
	protected static Map ma;
	protected static Window w;
	

	public static void main(String[] args) {
		c1 = new Characters(Character.PISTOL);
		b = new Characters[1];
		b[0]=new Characters(Character.BOT);
		ma = new Map();
		w = new Window();
		while(true) {
			
		}
	}
}
