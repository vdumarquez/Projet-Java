package jeu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Map {
	static final int NLin=16;
	static final int NCol=20;
	protected static EMap[][] lvl = new EMap[NLin][NCol];

	public Map() {
		LFile("niveau1.txt");
	}

	public void LFile(String s) {
		try {
			char c;
			InputStream flux = new FileInputStream(s);
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String line;
			int i = 0, j;
			while ((line = buff.readLine()) != null) {
				for (j = 0; j < 20; j++) {
					c = line.charAt(j);
					if(c=='1')
						lvl[i][j] = EMap.WALL;
					else
						lvl[i][j] = EMap.EMPTY;
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
