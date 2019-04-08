package jrJava.alienInvader5_polymorphism;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Alien {

	protected int x, y; // center. bottom
	protected int vx, vy;
	//private static int width, height;
	//private Color bodyColor, eyeColor;
	protected static int eyeRadius;
	protected boolean isCollided;
	protected static Color explosionColor;
	protected static int explosionRadius;
	protected Ship target;
	protected Image image, imageAlt;
	protected int width, height;
	
	protected int drawCount;
	protected int drawAltCycle = 12;;
	
	
	static {
		//width = 25;
		//height = 25;
		eyeRadius = 3;
		explosionColor = Color.pink;
		explosionRadius = 120;
	}
	
	
	public Alien(int x, int y, int vx, int vy, Image image, Image imageAlt, Ship target){
		this.x = x;
		this.y  = y;
		this.vx = vx;
		this.vy = vy;
		//this.bodyColor = bodyColor;
		//this.eyeColor = eyeColor;
		this.image = image;
		this.imageAlt = imageAlt;
		width = image.getWidth(null);
		height = image.getHeight(null);
		
		this.target = target;
	}
	

	public int getX(){ return x; }
	public int getY(){ return y; }
	//public static int getWidth(){ return width; }
	//public static int getHeight(){ return height; }
	public int getWidth(){ return width; }
	public int getHeight(){ return height; }
	
	
	
	public boolean isHit(Torpedo torpedo){
		
		if(torpedo.getX()>=x-width/2-Torpedo.getWidth()/2 &&
		   torpedo.getX()<=x+width/2+Torpedo.getWidth()/2 &&
		   torpedo.getY()>=y-height-Torpedo.getHeight()   &&
		   torpedo.getY()<=y){
			
			AlienManager.remove(this); 
			return true;
		}
		
		return false;
	}
	
	
	
	public void move(){
		x += vx;
		y += vy;
		
		if(y>720) AlienManager.remove(this); 
		
		if(x<0+width/2 || x>800-width/2) vx *= -1;
		
		shootMissile();
		
		isCollided = target.isHit(this);
	}
	
	
	
	public void shootMissile(){
		if(Math.random()<0.1 && MissileManager.seatAvailable()) MissileManager.add(new Missile(x, y + Missile.getHeight(), 2*vy, target));
		
	}
	
	
	
	public void draw(Graphics canvas){
		drawCount++;
		if(drawCount%drawAltCycle<drawAltCycle/2) canvas.drawImage(image, x-width/2, y-height, null);
		else canvas.drawImage(imageAlt, x-width/2, y-height, null);
		
		if(isCollided){
			canvas.setColor(explosionColor);
			canvas.drawOval(x-explosionRadius, y-explosionRadius, 2*explosionRadius, 2*explosionRadius);
			Coordinator.gameOn = false;
		}
	
	}
	
	
}
















