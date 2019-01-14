package jeu;

import java.util.ArrayList;

public class Game {
	protected static boolean IsStart = Boolean.FALSE;
	protected static Character CP=null;
	protected static Characters c1=null;
	protected static Bots b[];
	protected static Map ma;
	protected static Window w;
	protected static boolean po=false;
	protected static int count=0;
	protected static int score=0;
	protected static Boolean start=Boolean.FALSE;
	private static Boolean start_=Boolean.FALSE;
	protected static Boolean wh=Boolean.FALSE;
	protected static Boolean Islvl=Boolean.FALSE;
	public static ArrayList<Reward> Rew = new ArrayList<Reward>();
	public static Boolean Iskey=Boolean.FALSE;
	private static long tp=java.lang.System.currentTimeMillis(),tpo=java.lang.System.currentTimeMillis();
	private static long  tb[]=new long[6];
	
	public static void main(String[] args) {
		ma = new Map();
		b = new Bots[3];
		b[0]=new Bots(Character.ZPUNK);
		b[1]=new Bots(Character.ZFAT);
		b[2]=new Bots(Character.ZRED);
		c1= new Characters();
		w = new Window();
		
		for(int i=0;i<tb.length;i++)
			tb[i]=java.lang.System.currentTimeMillis();
		 
		while(true) {
			if(IsStart) {
				if(start)
					start_=Boolean.TRUE;
				Play();
			}else if(CP!=null){
				IsStart=Boolean.TRUE;
				c1.Init(CP);
				Rew.add(new Reward(Rewards.KEY));
			}
			w.pan.repaint();

		}
	}


	public static void Play() {
		if(start_) {
			if(c1.Isalive) {
				if(c1.nbl<=0)
					c1.Isalive=Boolean.FALSE;
				UpdatePlayer();
				UpdateBot();
				if(score!=0&&score%b.length==0&&Iskey) {
					Iskey=Boolean.FALSE;
					int x,y;
					do {
						x=(int) (Math.random()*20);
						y=(int) (Math.random()*16);
					}while(Map.lvl[y][x]!=EMap.EMPTY);
					Map.lvl[y][x]=EMap.PORTAL;
					Islvl=Boolean.TRUE;
				}
			}else {
				start=Boolean.FALSE;
			}
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
