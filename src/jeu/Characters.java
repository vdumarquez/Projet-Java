package jeu;




public class Characters extends Bots {
	
	protected Power p;

	
	public Characters(){
		super();
		p=new Power();
	}
	
	@Override
	public void Init(Character c) {
		Isalive=Boolean.TRUE;
		ch=c;
		setPosition();
		p.Init(c);
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
			if (Map.lvl[y_][x_] == EMap.EMPTY || Map.lvl[y_][x_] == EMap.REWARD) {
				if(Map.lvl[y_][x_] == EMap.REWARD)
					for(int i=0;i<Game.Rew.size();i++)
						if(y_==Game.Rew.get(i).y&&x_==Game.Rew.get(i).x)
							if(Game.Rew.get(i).r==Rewards.HEART) {
								nbl=nbl+1;
								Game.Rew.remove(i);
							}else if(Game.Rew.get(i).r==Rewards.KEY) {
								Game.Iskey=Boolean.TRUE;
								Game.Rew.remove(i);
							}
								
				Map.lvl[y_][x_] = EMap.PLAYER;
				Map.lvl[y][x] = EMap.EMPTY;
				x=x_;
				y=y_;
			}else if(Map.lvl[y_][x_]==EMap.PORTAL) {
				Game.start=Boolean.FALSE;
				Map.lvl=Map.LFile();
				Game.Rew.add(new Reward(Rewards.KEY));
				if(Map.niv%3==0) {
					Game.Rew.add(new Reward(Rewards.HEART));
				}
				Game.Islvl=Boolean.FALSE;
				for(int i=0;i<Game.b.length;i++) {
					Game.b[i].Reset();
				}
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
		nbl=4;
	}
	
	private void WarriorAr()  {
		name="WarriorAr";
		dir = Deplacement.IMMOBILE;
		setImage(name+"Up.png");
		v = 400;
		nbl=5;
	}
	
	private void WarriorFire()  {
		name="WarriorFire";
		dir = Deplacement.IMMOBILE;
		setImage(name+"Up.png");
		v = 700;
		nbl=3;
	}

	

}
