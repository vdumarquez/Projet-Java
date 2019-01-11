package jeu;




public class Characters extends Bots {
	
	protected int weight;
	protected Power p;
	
	public Characters(Character c){
		super(c);
		setPosition();
		p=new Power(ch);
		if(c==Character.WPISTOL) {
			WarriorPistol();
		}else if(c==Character.WAR) {
			WarriorAr();
		}else if(c==Character.WFIRE) {
			WarriorFire();
		}
	}
	
	@Override
	public void setPosition(){
		do {
			x=(int) (Math.random()*20);
			y=(int) (Math.random()*16);
		}while(Map.lvl[y][x]!=EMap.EMPTY);
		Map.lvl[y][x]=EMap.PLAYER;
	}
	
	@Override
	public void move() {
		int x_,y_;
		if(dir!=Deplacement.IMMOBILE) {
			x_=x;
			y_=y;
			switch (dir) {
			case HAUT:
				setImage(name+"Up.png");
				y_--;
				break;
			case BAS:
				setImage(name+"Down.png");
				y_++;

				break;
			case GAUCHE:
				setImage(name+"Left.png");
				x_--;
				break;
			case DROITE:
				setImage(name+"Right.png");
				x_++;
				break;
			default:
				break;
			}
			if (Map.lvl[y_][x_] == EMap.EMPTY) {
				Map.lvl[y_][x_] = EMap.PLAYER;
				Map.lvl[y][x] = EMap.EMPTY;
				x=x_;
				y=y_;
			}else if(Map.lvl[y_][x_]==EMap.PORTAL) {
				Game.start=Boolean.FALSE;
				Map.lvl=Map.LFile();
				setPosition();
			}
			dir=Deplacement.IMMOBILE;
		}
	}

	private void WarriorPistol()  {
		name="WarriorPistol";
		dir = Deplacement.IMMOBILE;
		setImage(name+"Up.png");
		v = 300;
		nbl=3;
	}
	
	private void WarriorAr()  {
		name="WarriorAr";
		dir = Deplacement.IMMOBILE;
		setImage(name+"Up.png");
		v = 500;
		nbl=3;
	}
	
	private void WarriorFire()  {
		name="WarriorFire";
		dir = Deplacement.IMMOBILE;
		setImage(name+"Up.png");
		v = 700;
		nbl=3;
	}

	

}
