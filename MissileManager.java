package jrJava.alienInvader5_polymorphism;

import java.awt.Graphics;

public class MissileManager {

	private static Missile[] missiles = new Missile[100];
	
	
	public static boolean seatAvailable(){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]==null) return true;
		}
		return false;
	}
	
	
	public static void add(Missile missile){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]==null){
				missiles[i] = missile;
				break;
			}
		}
	}
	
	
	public static void remove(Missile missile){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]==missile){
				missiles[i] = null;
				break;
			}
		}
	}
	
	
	public static boolean isHit(Torpedo torpedo){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]!=null && missiles[i].isHit(torpedo)) return true;	
		}
		return false;
	}
	
	
	public static void move(){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]!=null) missiles[i].move();
		}
	}
	
	
	public static void draw(Graphics canvas){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]!=null) missiles[i].draw(canvas);
		}
	}
	 
}







