package jeu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class Map {
	static final int NLin=16;
	static final int NCol=20;
	protected static EMap[][] lvl = new EMap[NLin][NCol];
	private static int niv=0;
	public Map() {
		lvl=LFile();
	}

	public static EMap[][] LFile() {
		String s,f="Fond";
		int r;
		do {
			r=(int)(Math.random()*5);
		}while(r==0);
		EMap[][] lvl_ = new EMap[NLin][NCol];
		if(niv==0) {
			niv=1;
			s="niveau1.txt";
		}else if(niv==1) {
			niv=2;
			s="niveau2.txt";
		}else if(niv==2) {
			niv=3;
			s="niveau1.txt";
		}else if(niv==3) {
			niv=4;
			s="niveau1.txt";
		}else {
			niv=0;
			s="niveau1.txt";
		}
		
		
		try {
			f=f+r+".jpg";
			PMap.Fond = ImageIO.read(new File(f));
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
						lvl_[i][j] = EMap.WALL;
					else
						lvl_[i][j] = EMap.EMPTY;
				}
				j = 0;
				i++;
			}
			buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lvl_;
	}
}
