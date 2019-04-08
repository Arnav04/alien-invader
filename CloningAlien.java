package jrJava.alienInvader5_polymorphism;

import java.awt.Image;

public class CloningAlien extends Alien{
	
	protected int distance;
	protected int requiredDistance;
	protected boolean hasCloned;

	public CloningAlien(int x, int y, int vx, int vy, Image image, Image imageAlt, Ship target) {
		super(x, y, vx, vy, image, imageAlt, target);
		
		distance = 0;
		requiredDistance = (int)(100+200*Math.random());
	
	}
	
	public void move(){
		x += vx;
		y += vy;
		
		if(distance>requiredDistance && !hasCloned){
			new CloningAlien(x, y, vx, vy, image, imageAlt, target);
		}
		
		if(y>720) AlienManager.remove(this); 
		
		if(x<0+width/2 || x>800-width/2) vx *= -1;
		
		shootMissile();
		
		isCollided = target.isHit(this);
	}
	
	

}
