package jeu;

public class Algo {
	private static EMap[][] PMap = new EMap[Map.NLin][Map.NCol];
	private static EMap[][] RMap = new EMap[Map.NLin][Map.NCol];
	
	/*
	 * Cette fonction permet de résoudre le chemin entre le bot et le joueur
	 * retourne vrai ou faux et enregistre le chemin dans le tableau PMap
	 */
private static Boolean Resolve(int x, int y) {
	Boolean h=Boolean.FALSE,b=Boolean.FALSE,g=Boolean.FALSE,d=Boolean.FALSE;
	if(RMap[y][x]==EMap.WALL||RMap[y][x]==EMap.EXPLORED) {
		return Boolean.FALSE;
	}
	else if(RMap[y][x]==EMap.BOT||RMap[y][x]==EMap.EMPTY||RMap[y][x]==EMap.POWER||RMap[y][x]==EMap.REWARD) {
		RMap[y][x]=EMap.EXPLORED;
	h=Resolve(x,y-1);
	b=Resolve(x,y+1);
	g=Resolve(x-1,y);
	d=Resolve(x+1,y);
	}
	else  if (RMap[y][x]==EMap.PLAYER) {
		PMap[y][x]=EMap.EXPLORED;
		return Boolean.TRUE;
	}

	if(h==Boolean.TRUE||b==Boolean.TRUE||g==Boolean.TRUE||d==Boolean.TRUE) {
		PMap[y][x]=EMap.EXPLORED;
		return Boolean.TRUE;
	}
	else
		return Boolean.FALSE;
}

/*
 * Cette fonction permet de savoir dans quelle direction doit se diriger le bot en fonction du chemin
 * retourne la bonne direction
 */
public static Deplacement Move_Bot(int x, int y) {
	for(int i=0;i<Map.NLin;i++) {
		for(int j=0;j<Map.NCol;j++) {
			PMap[i][j]=Map.lvl[i][j];
			RMap[i][j]=Map.lvl[i][j];
		}
	}
	Resolve(x,y);
	if(PMap[y-1][x]==EMap.EXPLORED) 
		return Deplacement.HAUT;
	else if(PMap[y+1][x]==EMap.EXPLORED) 
		return Deplacement.BAS;
	else if(PMap[y][x-1]==EMap.EXPLORED) 
		return Deplacement.GAUCHE;
	else 
		return Deplacement.DROITE;
}
}
