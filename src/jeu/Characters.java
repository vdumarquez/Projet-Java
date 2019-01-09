package jeu;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Characters {
	protected int x;
	protected int y;
	protected int nbl;
	private int nbl_;
	protected int weight;
	protected Power p;
	protected Image I;
	protected Deplacement dir;
	protected long v;
	private String name;

	public Characters(Character c){
		do {
			x=(int) (Math.random()*20);
			y=(int) (Math.random()*16);
		}while(Map.lvl[y][x]!=EMap.EMPTY);
		if(c==Character.WPISTOL) {
			WarriorPistol();
			Map.lvl[y][x] = EMap.PLAYER;
		}else if(c==Character.ZPUNK) {
			ZPUNK();
			Map.lvl[y][x] = EMap.BOT;
		}else if(c==Character.ZFAT) {
			ZFAT();
			Map.lvl[y][x] = EMap.BOT;
		}else if(c==Character.ZRED) {
			ZRED();
			Map.lvl[y][x] = EMap.BOT;
		}
	}

	public void move() {
		int x_,y_;
		if(dir!=Deplacement.IMMOBILE) {
			x_=x;
			y_=y;
			switch (dir) {
			case HAUT:
				setImage(name+"Up.png");
				y_--;
				break;
			case BAS:
				setImage(name+"Down.png");
				y_++;

				break;
			case GAUCHE:
				setImage(name+"Left.png");
				x_--;
				break;
			case DROITE:
				setImage(name+"Right.png");
				x_++;
				break;
			default:
				break;
			}
			if (Map.lvl[y_][x_] == EMap.EMPTY) {
				if(name.contains("Zombi"))
					Map.lvl[y_][x_] = EMap.BOT;
				else
					Map.lvl[y_][x_] = EMap.PLAYER;
				Map.lvl[y][x] = EMap.EMPTY;
				x=x_;
				y=y_;
			}
			dir=Deplacement.IMMOBILE;
		}
	}

	private void WarriorPistol()  {
		name="WarriorPistol";
		dir = Deplacement.IMMOBILE;
		setImage(name+"Up.png");
		v = 300;
		nbl=3;
		p=new Gun();
	}

	private void ZPUNK() {
		name="ZombiPunk";
		setImage(name+"Up.png");
		v = 500;
		nbl=3;
		nbl_=nbl;
	}

	private void ZFAT() {
		name="ZombiFat";
		setImage(name+"Up.png");
		v = 800;
		nbl=5;
		nbl_=nbl;
	}

	private void ZRED() {
		name="ZombiRedhair";
		setImage(name+"Up.png");
		v = 300;
		nbl=2;
		nbl_=nbl;
	}


	public void Reset() {
		if(name.contains("Red")) {
			nbl=nbl_;
			v=v-10;
			if(v<100) {
				v=100;
				nbl=1;
			}
		}else if(name.contains("Fat")) {
			nbl_++;
			nbl=nbl_;
		}else if(name.contains("Punk")) {
			v=v-10;
			if(v<=300) {
				nbl_++;
				nbl=nbl_;
				v=300;
			}
		}
	}

	public void setImage(String s) {
		try {
			I = ImageIO.read(new File(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
