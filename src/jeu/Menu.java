package jeu;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;



public class Menu extends JLayeredPane {
	public Menu() {
	}
	public void paintComponent(Graphics g) {
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
}
