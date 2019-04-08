package jrJava.alienInvader5_polymorphism;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile {

	private int x, y; // center, bottom
	private int vy; // vy>0
	private static int width, height;
	//private static Color color;
	private static Image image;
	private boolean isCollided;
	private static Color explosionColor;
	private static int explosionRadius;
	private Ship target;
	
	
	static {
		image = new ImageIcon(Coordinator.R_PATH + "missile.png").getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
		//color = Color.red;
		explosionColor = new Color(0, 180, 0);
		explosionRadius = 100;
	}
	
	
	public Missile(int x, int y, int vy, Ship target){
		this.x = x;
		this.y = y;
		this.vy = vy;
		this.target = target;
	}
	
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	public static int getWidth(){ return width; }
	public static int getHeight(){ return height; }
	
	
	
	public boolean isHit(Torpedo torpedo){

		if(torpedo.getX()>=x-width/2-Torpedo.getWidth()/2 &&
		   torpedo.getX()<=x+width/2+Torpedo.getWidth()/2 &&
		   torpedo.getY()>=y-height-Torpedo.getHeight()   &&
		   torpedo.getY()<=y){
			
			MissileManager.remove(this); 
			return true;
		}
		
		return false;
	}
	
	
	
	public void move(){
		y += vy;
		
		if(y>720) MissileManager.remove(this); 
		
		isCollided = target.isHit(this);
	}
	
	
	public void draw(Graphics canvas){
		//canvas.setColor(color);
		//canvas.drawRect(x-width/2, y-height, width, height);
		canvas.drawImage(image, x-width/2, y-height, null);
		
		if(isCollided){
			canvas.setColor(explosionColor);
			canvas.drawOval(x-explosionRadius, y-explosionRadius, 2*explosionRadius, 2*explosionRadius);
			Coordinator.gameOn = false;
		}
	}
	
	
}








