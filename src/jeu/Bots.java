package jeu;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bots {
	protected int x;
	protected int y;
	protected double nbl;
	private double nbl_;
	protected Image I;
	protected Deplacement dir;
	protected long v;
	protected String name;
	protected Character ch;
	protected Boolean Isalive;
	
	
	public Bots(Character c) {
		ch=c;
		Isalive=Boolean.TRUE;
		Init(c);
	}

	public void Init(Character c) {
		if(c.toString().contains("Z"))
			setPosition();
		if(c==Character.ZPUNK) {
			ZPUNK();
		}else if(c==Character.ZFAT) {
			ZFAT();
		}else if(c==Character.ZRED) {
			ZRED();
		}
	}
	public void setPosition(){
		do {
			x=(int) (Math.random()*20);
			y=(int) (Math.random()*16);
		}while(Map.lvl[y][x]!=EMap.EMPTY);
		Map.lvl[y][x]=EMap.BOT;
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
		Isalive=Boolean.TRUE;
		setPosition();
		if(name.contains("Red")) {
			nbl=nbl_;
			v=v-10;
			if(v<100) {
				v=100;
			}
		}else if(name.contains("Fat")) {
			nbl_++;
			nbl=nbl_;
		}else if(name.contains("Punk")) {
			v=v-10;
			nbl=nbl_;
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
			if (Map.lvl[y_][x_] == EMap.EMPTY || Map.lvl[y_][x_] == EMap.POWER ) {
					Map.lvl[y_][x_] = EMap.BOT;
				Map.lvl[y][x] = EMap.EMPTY;
				x=x_;
				y=y_;
			}else if(Map.lvl[y_][x_] == EMap.PLAYER) {
				Game.c1.nbl--;
			}
			dir=Deplacement.IMMOBILE;
		}
	}
}
