package jeu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Map {
	protected char[][] lvl = new char[16][20];

	public Map() {
		LFile("niveau1.txt");
		lvl[Game.c1.y][Game.c1.x] = 50;
		lvl[Game.b1.y][Game.b1.x] = 50;
	}

	public void LFile(String s) {
		try {
			InputStream flux = new FileInputStream(s);
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String line;
			int i = 0, j;
			while ((line = buff.readLine()) != null) {
				for (j = 0; j < 20; j++) {
					lvl[i][j] = line.charAt(j);
				}
				j = 0;
				i++;
			}
			buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
