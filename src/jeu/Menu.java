package jeu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
			for (int i = 0; i < Game.c1.nbl; i++)
				g.drawImage(Heart, (int) (0.05 * this.getWidth() + 0.05 * this.getWidth() * i),
						(int) (0.86 * this.getHeight()), this.getWidth() / 20, this.getHeight() / 20, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
