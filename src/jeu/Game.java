package jeu;

public class Game {
	protected static Characters c1=null;
	protected static Bots b[];
	protected static Map ma;
	protected static Window w;
	protected static boolean po=false;
	protected static int count=0;
	protected static int score=0;
	protected static Boolean start=Boolean.FALSE;
	private static Boolean start_=Boolean.FALSE;
	private static Boolean wh=Boolean.FALSE;
	private static long tp=java.lang.System.currentTimeMillis(),tpo=java.lang.System.currentTimeMillis();
	private static long  tb[]=new long[6];
	public static void main(String[] args) {
		ma = new Map();
		b = new Bots[3];
		b[0]=new Bots(Character.ZPUNK);
		b[1]=new Bots(Character.ZFAT);
		b[2]=new Bots(Character.ZRED);

		w = new Window();

		for(int i=0;i<tb.length;i++)
			tb[i]=java.lang.System.currentTimeMillis();
		while(true) {
			if(c1!=null)
				wh=Boolean.TRUE;
			while(wh) {
				if(start)
					start_=Boolean.TRUE;
				if(c1.nbl<=0) {
					for(int i=0;i<b.length;i++) {
						b[i].Init(b[i].ch);
					}
					Map.lvl[c1.y][c1.x]=EMap.EMPTY;
				}
				if(score>0) {
					for(int i=0;i<b.length;i++) {
						b[i].Reset();
					}
				}
				w.pan.repaint();
				Play();
			}
			w.pan.repaint();
			if(c1==null)
				wh=Boolean.FALSE;
		}
	}


	public static void Play() {
		while(start_) {
			if(c1.nbl<=0) {
				start=Boolean.FALSE;
			}else {
				UpdatePlayer();
				UpdateBot();
			}
			w.pan.repaint();
			start_=start;
		}
	}
	
	private static void UpdatePlayer() {
		if(java.lang.System.currentTimeMillis()-tp>=c1.v) {
			c1.move();
			tp=java.lang.System.currentTimeMillis();
		}
		if(po&&(java.lang.System.currentTimeMillis()-tpo)>=c1.p.v) {
			c1.p.Active();
			tpo=java.lang.System.currentTimeMillis();
		}
	}
	
	private static void UpdateBot() {
		for(int i=0;i<b.length;i++) {
			if(b[i].nbl<=0&&b[i].Isalive) {
				b[i].Isalive=Boolean.FALSE;
				Map.lvl[b[i].y][b[i].x]=EMap.EMPTY;
				b[i].dir=Deplacement.IMMOBILE;
				b[i].x=0;
				b[i].y=0;
				score=score+1;
				if(score!=0&&score%b.length==0) {
					int x,y;
					do {
						x=(int) (Math.random()*20);
						y=(int) (Math.random()*16);
					}while(Map.lvl[y][x]!=EMap.EMPTY);
					Map.lvl[y][x]=EMap.PORTAL;

				}
			}else if(b[i].nbl>0){
				if(java.lang.System.currentTimeMillis()-tb[i]>=b[i].v) {
					if(b[i].nbl>0) {
						b[i].dir=Algo.Move_Bot(b[i].x, b[i].y);
						b[i].move();
						tb[i]=java.lang.System.currentTimeMillis();
					}
				}
			}
		}
	}
}
