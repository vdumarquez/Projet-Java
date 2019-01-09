package jeu;

public class Game {
	protected static Characters c1;
	protected static Characters b[];
	protected static Map ma;
	protected static Window w;
	protected static boolean po=false;
	protected static int count=0;
	protected static int score=0;
	protected static boolean start=false;

	public static void main(String[] args) {
		ma = new Map();
		c1 = new Characters(Character.WPISTOL);
		b = new Characters[6];
		b[0]=new Characters(Character.ZPUNK);
		b[1]=new Characters(Character.ZFAT);
		b[2]=new Characters(Character.ZRED);
		b[3]=new Characters(Character.ZPUNK);
		b[4]=new Characters(Character.ZFAT);
		b[5]=new Characters(Character.ZRED);
		w = new Window();
		while(true) {
		Play();
		}
		
	}
	
	public static void Play() {
		long tp=java.lang.System.currentTimeMillis(),tpo=java.lang.System.currentTimeMillis();
		long tb[]=new long[6];
		for(int i=0;i<tb.length;i++)
			tb[i]=java.lang.System.currentTimeMillis();
		System.out.println(start);
		while(start) {
			w.pan.repaint();
			if(java.lang.System.currentTimeMillis()-tp>=c1.v) {
				c1.move();
				tp=java.lang.System.currentTimeMillis();
			}
			for(int i=0;i<b.length;i++) {
				if(java.lang.System.currentTimeMillis()-tb[i]>=b[i].v) {

					b[i].dir=Deplacement.DROITE;
					b[i].move();
					tb[i]=java.lang.System.currentTimeMillis();
				}
			}
			if(po&&(java.lang.System.currentTimeMillis()-tpo)>=c1.p.v) {
				c1.p.Active();
				tpo=java.lang.System.currentTimeMillis();
				}
			for(int i=0;i<b.length;i++) {
				if(b[i].nbl==0) {
					Map.lvl[b[i].y][b[i].x]=EMap.EMPTY;
					b[i].Reset();
					score=score+1;
				}
				
		}
	}
	}
}
