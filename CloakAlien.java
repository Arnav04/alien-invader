package jrJava.alienInvader5_polymorphism;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class CloakAlien extends Alien {

	
	protected float transparency;
	protected float cloakRate;
	
	
	public CloakAlien(int x, int y, int vx, int vy, Image image, Image imageAlt, Ship target){
		super(x, y, vx, vy, image, imageAlt, target); 
		
		transparency = 1.0f;
		cloakRate = 0.01f;
	}
	
	

	public void draw(Graphics canvas){
		
		Graphics2D canvas2D = (Graphics2D)canvas;
		Composite original = canvas2D.getComposite();
		
		transparency -= cloakRate;
		if(transparency<0) transparency = 0.0f;
		if(isCollided) transparency = 1.0f;
		
		Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency);
		canvas2D.setComposite(c);
		
		drawCount++;
		if(drawCount%drawAltCycle<drawAltCycle/2) canvas.drawImage(image, x-width/2, y-height, null);
		else canvas.drawImage(imageAlt, x-width/2, y-height, null);
		
		canvas2D.setComposite(original);
		
		if(isCollided){
			canvas.setColor(explosionColor);
			canvas.drawOval(x-explosionRadius, y-explosionRadius, 2*explosionRadius, 2*explosionRadius);
			Coordinator.gameOn = false;
		}
	
	}
	
}








