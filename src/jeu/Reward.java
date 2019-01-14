package jeu;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Reward {
	protected int x;
	protected int y;
	protected Image I;
	protected Rewards r;

	public Reward(Rewards r_) {
		do {
			x=(int) (Math.random()*20);
			y=(int) (Math.random()*16);
		}while(Map.lvl[y][x]!=EMap.EMPTY);
		Map.lvl[y][x]=EMap.REWARD;
		r=r_;
		try {
			if(r_==Rewards.HEART) 
				I=ImageIO.read(new File("Coeur_p.png"));
			else if(r_==Rewards.KEY)
				I=ImageIO.read(new File("PausePlay.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
