package jrJava.alienInvader5_polymorphism;

import java.awt.Image;

public class RealNastyAlien extends MultiShootAlien {

	public RealNastyAlien(int x, int y, int vx, int vy, Image image, Image imageAlt, Ship target){
		super(x, y, vx, vy, image, imageAlt, target);
	}

	public void move(){

		x += (int)(0.95*x + 0.05*target.getX()); // x + target.getX()/2;
		y += vy;

		if(y>720) AlienManager.remove(this); 

		if(x<0+width/2 || x>800-width/2) vx *= -1;

		shootMissile();

		isCollided = target.isHit(this);
	}




}
