package jrJava.alienInvader5_polymorphism;

import java.awt.Graphics;

public class TorpedoManager {

	private static Torpedo[] torpedoes = new Torpedo[20];  
	
	
	public static boolean seatAvailable(){
		for(int i=0; i<torpedoes.length; i++){
			if(torpedoes[i]==null) return true;
		}
		return false;
	}
	
	
	public static void add(Torpedo torpedo){ 
		for(int i=0; i<torpedoes.length; i++){
			if(torpedoes[i]==null) {
				torpedoes[i] = torpedo;
				break;
			}
		}
	}
	
	
	public static void remove(Torpedo torpedo){ 
		for(int i=0; i<torpedoes.length; i++){
			if(torpedoes[i]==torpedo){
				torpedoes[i] = null;
			}
		}
	}
	
	
	public static void move(){
		for(int i=0; i<torpedoes.length; i++){ 
			if(torpedoes[i]!=null) torpedoes[i].move();
		}
		
	}
	
	
	public static void draw(Graphics canvas){
		for(int i=0; i<torpedoes.length; i++){ 
			if(torpedoes[i]!=null) torpedoes[i].draw(canvas); 
		}
	}
	
}











