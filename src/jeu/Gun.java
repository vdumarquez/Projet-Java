package jeu;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Gun extends Power {
	public Gun() {
		try {
			I = ImageIO.read(new File("Sword_power.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		direction=null;
		F=1;
		t=0;
		thp= new ThPower();
		thp.start();
	}

	
}
