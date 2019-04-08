package jrJava.alienInvader5_polymorphism;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Torpedo {

	private int x, y; // center, top
	private int vy; // vy<0
	private static int width, height;
	//private static Color color;
	private static Image image;
	private boolean isCollidedWithAlien, isCollidedWithMissile;
	private static int explosionRadiusBig, explosionRadiusSmall;
	private static Color explosionColorBig, explosionColorSmall;
	
	
	static {
		image = new ImageIcon(Coordinator.R_PATH + "torpedo.png").getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
		//color = Color.blue;
		explosionRadiusBig = 60;
		explosionRadiusSmall = 40;
		explosionColorBig = Color.orange;
		explosionColorSmall = Color.magenta;
	}
	
	
	public Torpedo(int x, int y, int vy){
		this.x = x;
		this.y = y;
		this.vy = vy;
	}
	
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	public static int getWidth(){ return width; }
	public static int getHeight(){ return height; }
	
	
	public void move(){
		y += vy;
		
		if(y<50) TorpedoManager.remove(this);
		
		isCollidedWithAlien = AlienManager.isHit(this);
		isCollidedWithMissile = MissileManager.isHit(this);
	}
	
	
	public void draw(Graphics canvas){
		//canvas.setColor(color);
		//canvas.drawRect(x-width/2, y, width, height);
		canvas.drawImage(image, x-width/2, y, null);
		
		if(isCollidedWithAlien){
			canvas.setColor(explosionColorBig);
			canvas.drawOval(x-explosionRadiusBig, y-explosionRadiusBig, 2*explosionRadiusBig, 2*explosionRadiusBig);
			TorpedoManager.remove(this); 
		}
		
		if(isCollidedWithMissile){
			canvas.setColor(explosionColorSmall);
			canvas.drawOval(x-explosionRadiusSmall, y-explosionRadiusSmall, 2*explosionRadiusSmall, 2*explosionRadiusSmall);
			TorpedoManager.remove(this); 
		}
		
	}
	
}
 











