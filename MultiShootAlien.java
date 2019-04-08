package jrJava.alienInvader5_polymorphism;

import java.awt.Image;

public class MultiShootAlien extends Alien {


	public MultiShootAlien(int x, int y, int vx, int vy, Image image, Image imageAlt, Ship target){
		super(x, y, vx, vy, image, imageAlt, target);



	}

	public void shootMissile(){
		if(Math.random()<0.1 && MissileManager.seatAvailable()) 
			MissileManager.add(new Missile(x-width/4, y + Missile.getHeight(), 2*vy, target));
			MissileManager.add(new Missile(x, y + Missile.getHeight(), 2*vy, target));
			MissileManager.add(new Missile(x+width/4, y + Missile.getHeight(), 2*vy, target));
	}

}
