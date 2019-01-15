package jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PMap extends JPanel {
	private Image FondDP;
	private Image mapp;
	private Image Portal;
	private Image FondM;
	private Image Heart;
	private Image PaPl;
	private Image FondDG;
	private Image PTS;
	private Image ZOM;
	static Image Fond; 
	
	public PMap(){
		try {
			FondDP = ImageIO.read(new File("MW1.jpg"));
			mapp = ImageIO.read(new File("mur1.png"));
			Portal = ImageIO.read(new File("Portal.png"));
			FondM = ImageIO.read(new File("Fond_Menu.jpg"));
			Heart = ImageIO.read(new File("Coeur_p.png"));
			PaPl = ImageIO.read(new File("PausePlay.png"));
			FondDG = ImageIO.read(new File("GameOver.png"));
			PTS = ImageIO.read(new File("PressToStart.png"));
			ZOM = ImageIO.read(new File("Zombihead.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g) {
		if(Game.IsStart) {
			if(Game.c1.nbl>0) {
				DMenu(g);
				DMap(g);
				if(Game.start==Boolean.FALSE&&Game.c1.nbl>0)
					DPlay(g);
			}else
				DGameOver(g);
		}else {
			DPreS(g);
		}
	}

	private void DMap(Graphics g) {
		g.drawImage(Fond, 0,0, this.getWidth(), (int) (this.getHeight() * 0.85),this);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 20; j++) {
				if (Map.lvl[i][j] == EMap.WALL)
					g.drawImage(mapp, j * this.getWidth() / 20,
							(int)(0.85*i * this.getHeight() / 16), this.getWidth() / 20,
							(int)(0.85*this.getHeight() / 16), this);
				else if (Map.lvl[i][j] == EMap.PLAYER)
					g.drawImage(Game.c1.I, j * this.getWidth() / 20,
							(int)(0.85*i * this.getHeight() / 16), this.getWidth() / 20,
							(int)(0.85*this.getHeight() / 16), this);
				else if(Map.lvl[i][j] == EMap.POWER) {
					if(Game.c1.ch==Character.WFIRE) {
						g.drawImage(Game.c1.p.IF, j * this.getWidth() / 20,
								(int)(0.85*i * this.getHeight() / 16), this.getWidth()/20,
								this.getHeight()/20, this);
					}else {
					g.drawImage(Game.c1.p.IF, (int)(0.02*this.getWidth())+j * this.getWidth() / 20,
							(int) (0.035 * this.getHeight()) + i * this.getHeight() / 20, this.getWidth() / 100,
							this.getHeight() / 100, this);
					}
				}
				else if(Map.lvl[i][j]==EMap.BOT) {
					int k;
					for(k=0;k<Game.b.length;k++) {
						if(j==Game.b[k].x&&i==Game.b[k].y)
							break;
					}
					if(k<Game.b.length)
						g.drawImage(Game.b[k].I,  j * this.getWidth() / 20,
								(int)(0.85*i * this.getHeight() / 16), this.getWidth() / 20,
								(int)(0.85*this.getHeight() / 16), this);
				}else if(Map.lvl[i][j]==EMap.PORTAL) {
					g.drawImage(Portal, j * this.getWidth() / 20,
							(int)(0.85*i * this.getHeight() / 16), this.getWidth() / 20,
							(int)(0.85*this.getHeight() / 16), this);
				}else if(Map.lvl[i][j]==EMap.REWARD) {
						for(int k=0;k<Game.Rew.size();k++)
							if(i==Game.Rew.get(k).y&&j==Game.Rew.get(k).x)
									g.drawImage(Game.Rew.get(k).I, j * this.getWidth() / 20,
											(int)(0.85*i * this.getHeight() / 16), this.getWidth() / 20,
											(int)(0.85*this.getHeight() / 16), this);
				}
			}	
		}
	}

	private void DMenu(Graphics g) {
		g.drawImage(FondM, 0, (int) (0.85 * this.getHeight()), this.getWidth(), (int) (this.getHeight() * 0.2),
				this);
		for (int i = 0; i < Game.c1.nbl; i++)
			g.drawImage(Heart, (int) (0.05 * this.getWidth() + 0.05 * this.getWidth() * i),
					(int) (0.86 * this.getHeight()), this.getWidth() / 20, this.getHeight() / 20, this);
		g.drawImage(ZOM,(int) (0.3* this.getWidth()),(int) (0.87 * this.getHeight()), this.getWidth() / 10, this.getHeight() / 10, this);
		g.setFont(new Font("TimesRoman", Font.PLAIN, this.getHeight()/25));
		g.drawString(Integer.toString(Game.score),(int) (0.4* this.getWidth()),(int) (0.94 * this.getHeight()));
		g.drawString("J", (int) (8* this.getWidth()/15), (int) (0.97 * this.getHeight()));
		g.drawString("P", (int) (0.7* this.getWidth()), (int) (0.97 * this.getHeight()));
		g.drawImage(Game.c1.p.I, (int) (0.5 * this.getWidth()),
				(int) (0.87 * this.getHeight()), this.getWidth() / 15, this.getHeight() / 15, this);
		g.drawImage(PaPl, (int) (0.7 * this.getWidth()),
				(int) (0.87 * this.getHeight()), this.getWidth() / 15, this.getHeight() / 15, this);
	}
	private void DGameOver(Graphics g) {
		g.drawImage(FondDG, 0, 0, this.getWidth(), this.getHeight(),this);
		g.setFont(new Font("TimesRoman", Font.PLAIN, this.getHeight()/5));
		g.setColor(Color.white);
		g.drawString(Integer.toString(Game.score),(int) (0.82* this.getWidth()),(int) (0.2 * this.getHeight()));
	}

	private void DPlay(Graphics g) {
		g.drawImage(PTS, (int) (0.05* this.getWidth()), (int) (0.85 * this.getHeight()) , this.getWidth()/5, this.getHeight()/5,this);
	}

	private void DPreS(Graphics g) {
		g.drawImage(FondDP, 0, 0, this.getWidth(), this.getHeight(),this);
	}
}
