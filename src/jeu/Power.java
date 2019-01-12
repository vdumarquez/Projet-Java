package jeu;




import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Power {
	protected Image I;
	protected Image IF;
	protected double F;
	static protected Deplacement direction;
	protected int d;
	protected int x;
	protected int y;
	protected long v;
	private String mun;
	public void Init(Character c) {
		if(c==Character.WPISTOL) {
			try {
				I = ImageIO.read(new File("Pistol.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			direction=null;
			F=1;
			d=4;
			v=100;
			mun="Bulllet";
		}else if(c==Character.WAR) {
			try {
				I = ImageIO.read(new File("AR.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			direction=null;
			F=0.5;
			d=3;
			v=50;
			mun="Bulllet";
		}else if(c==Character.WFIRE) {
			try {
				I = ImageIO.read(new File("LanceFlamme.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			direction=null;
			F=2;
			d=1;
			v=100;
			mun="Fire";
		}
	}
	protected void Active() {
		// TODO Auto-generated method stub
		int x_,y_;
		x_=x;
		y_=y;
		if(mun=="Fire")
			PFire(x_,y_);
		else
			PBullet(x_,y_);
	}

	private void PBullet(int x_,int y_) {
		if(Game.count<d) {
			Game.count++;

			try {
				switch(direction) {
				case HAUT:
					IF=ImageIO.read(new File(mun+"Up.png"));
					y_--;
					break;
				case BAS:
					IF=ImageIO.read(new File(mun+"Down.png"));
					y_++;
					break;
				case GAUCHE:
					IF=ImageIO.read(new File(mun+"Left.png"));
					x_--;
					break;
				case DROITE:
					IF=ImageIO.read(new File(mun+"Right.png"));
					x_++;
					break;
				default:
					break;
				}
			}catch(IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Map.lvl[y_][x_]==EMap.EMPTY) {
				Map.lvl[y_][x_]=EMap.POWER;
				if(Map.lvl[y][x]==EMap.POWER)
					Map.lvl[y][x]=EMap.EMPTY;
				x=x_;
				y=y_;
			}
			else if(Map.lvl[y_][x_]==EMap.BOT) {
				int i;
				for(i=0;i<Game.b.length;i++) {
					if(x_==Game.b[i].x&&y_==Game.b[i].y)
						break;
				}
				Game.b[i].nbl=Game.b[i].nbl-Game.c1.p.F;
				if(Map.lvl[y][x]==EMap.POWER)
					Map.lvl[y][x]=EMap.EMPTY;
				Game.count=0;
				Game.po=false;
			}

		}else {
			if(Map.lvl[y][x]==EMap.POWER)
				Map.lvl[y][x]=EMap.EMPTY;
			Game.po=false;
			Game.count=0;
		}
	}
	private void PFire(int x_,int y_) {
		Deplacement dir = direction;
		try {
			if(Game.count<d) {
				Game.count++;
				for(int i=0;i<2;i++ ) {
					switch(dir) {
					case HAUT:
						IF=ImageIO.read(new File(mun+"Up.png"));
						y_--;
						break;
					case BAS:
						IF=ImageIO.read(new File(mun+"Down.png"));
						y_++;
						break;
					case GAUCHE:
						IF=ImageIO.read(new File(mun+"Left.png"));
						x_--;
						break;
					case DROITE:
						IF=ImageIO.read(new File(mun+"Right.png"));
						x_++;
						break;
					default:
						break;
					}
					if(y_<16&&y_>=0&&x_<20&&x_>=0) {
						if(Map.lvl[y_][x_]==EMap.EMPTY) {
							Map.lvl[y_][x_]=EMap.POWER;
							x=x_;
							y=y_;
						}else if(Map.lvl[y_][x_]==EMap.WALL) {
							break;
						}else if(Map.lvl[y_][x_]==EMap.BOT) {
							int j;
							for(j=0;j<Game.b.length;j++) {
								if(x_==Game.b[j].x&&y_==Game.b[j].y)
									break;
							}
							Game.b[j].nbl=Game.b[j].nbl-Game.c1.p.F;
						}
					}
				}
			}else {
				Game.count=0;
				Game.po=false;
				for(int i=0;i<2;i++) {
					if(Map.lvl[y_][x_]==EMap.POWER)
						Map.lvl[y_][x_]=EMap.EMPTY;
					switch(dir) {
					case HAUT:
						y_++;
						break;
					case BAS:
						y_--;
						break;
					case GAUCHE:
						x_++;
						break;
					case DROITE:
						x_--;
						break;
					default:
						break;
					}
				}
			}
		}catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
