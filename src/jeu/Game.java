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

		long tp=0,tb=0;
		while(true) {
			tp=tp+ java.lang.System.currentTimeMillis();
			if(tp>=c1.v) {
				c1.move();
				tp=0;
			}
			tb=tb + java.lang.System.currentTimeMillis();
			if(tb>=b[0].v) {
				b[0].dir=Deplacement.DROITE;
				b[0].move();
				tb=0;
			}

		}
	}
}
