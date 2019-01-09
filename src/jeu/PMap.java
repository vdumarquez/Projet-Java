package jeu;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PMap extends JPanel {

	public void paintComponent(Graphics g) {
		DMenu(g);
		if(Game.c1.nbl>0)
			DMap(g);
		else
			DGameOver(g);
		if(Game.start==false)
			DPlay(g);
	}

	private void DMap(Graphics g) {
		try {
			Image Fond = ImageIO.read(new File("Fond1.jpg"));
			g.drawImage(Fond, 0, (int) (0.05 * this.getHeight()), this.getWidth(), (int) (this.getHeight() * 0.8),
					this);
			Image mapp = ImageIO.read(new File("mur1.png"));
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 20; j++) {
					if (Map.lvl[i][j] == EMap.WALL)
						g.drawImage(mapp, j * this.getWidth() / 20,
								(int) (0.05 * this.getHeight()) + i * this.getHeight() / 20, this.getWidth() / 20,
								this.getHeight() / 20, this);
					else if (Map.lvl[i][j] == EMap.PLAYER)
						g.drawImage(Game.c1.I, j * this.getWidth() / 20,
								(int) (0.05 * this.getHeight()) + i * this.getHeight() / 20, this.getWidth() / 20,
								this.getHeight() / 20, this);
					else if(Map.lvl[i][j] == EMap.POWER) {
	
						g.drawImage(Game.c1.p.IF, (int)(0.02*this.getWidth())+j * this.getWidth() / 20,
								(int) (0.07 * this.getHeight()) + i * this.getHeight() / 20, this.getWidth() / 100,
								this.getHeight() / 100, this);
					}
					else if(Map.lvl[i][j]==EMap.BOT) {
						int k;
						for(k=0;k<Game.b.length;k++) {
							if(j==Game.b[k].x&&i==Game.b[k].y)
								break;
						}
						g.drawImage(Game.b[k].I, j * this.getWidth() / 20,
								(int) (0.05 * this.getHeight()) + i * this.getHeight() / 20, this.getWidth() / 20,
								this.getHeight() / 20, this);
					}
				}	
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void DMenu(Graphics g) {
		try {
			Image FondM = ImageIO.read(new File("Fond_Menu.jpg"));
			Image Heart = ImageIO.read(new File("Coeur_p.png"));
			g.drawImage(FondM, 0, (int) (0.85 * this.getHeight()), this.getWidth(), (int) (this.getHeight() * 0.2),
					this);
			g.drawImage(FondM, 0, 0, this.getWidth(), (int) (this.getHeight() * 0.05),
					this);
			for (int i = 0; i < Game.c1.nbl; i++)
				g.drawImage(Heart, (int) (0.05 * this.getWidth() + 0.05 * this.getWidth() * i),
						(int) (0.86 * this.getHeight()), this.getWidth() / 20, this.getHeight() / 20, this);
					g.setFont(new Font("TimesRoman", Font.PLAIN, this.getHeight()/25));
					g.drawString("J", (int) (8* this.getWidth()/15), (int) (0.97 * this.getHeight()));
				g.drawImage(Game.c1.p.I, (int) (0.5 * this.getWidth()),
						(int) (0.87 * this.getHeight()), this.getWidth() / 15, this.getHeight() / 15, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void DGameOver(Graphics g) {
		try {
			Image Fond = ImageIO.read(new File("GameOver.png"));
			g.drawImage(Fond, 0, (int) (0.05 * this.getHeight()), this.getWidth(), (int) (this.getHeight() * 0.8),
					this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void DPlay(Graphics g) {
			g.drawString("Press P to start", (int) (0.4* this.getWidth()), (int) (0.5 * this.getHeight()));
	}
}
