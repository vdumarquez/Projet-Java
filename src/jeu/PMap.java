package jeu;

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
		try {
			if(Game.c1.nbl>0) {
			Image Fond = ImageIO.read(new File("Fond1.jpg"));
			g.drawImage(Fond, 0, (int) (0.05 * this.getHeight()), this.getWidth(), (int) (this.getHeight() * 0.8),
					this);
			Image mapp = ImageIO.read(new File("mur1.png"));
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 20; j++) {
					if (Game.ma.lvl[i][j] == 49)
						g.drawImage(mapp, j * this.getWidth() / 20,
								(int) (0.05 * this.getHeight()) + i * this.getHeight() / 20, this.getWidth() / 20,
								this.getHeight() / 20, this);
					else if (Game.ma.lvl[i][j] == 50)
						g.drawImage(Game.c1.I, j * this.getWidth() / 20,
								(int) (0.05 * this.getHeight()) + i * this.getHeight() / 20, this.getWidth() / 20,
								this.getHeight() / 20, this);
				}
			}
			}else {
				Image Fond = ImageIO.read(new File("GameOver.png"));
				g.drawImage(Fond, 0, (int) (0.05 * this.getHeight()), this.getWidth(), (int) (this.getHeight() * 0.8),
						this);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
