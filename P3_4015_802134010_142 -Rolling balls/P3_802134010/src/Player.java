 import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * constructs a player1 object in the game 
 * @author geraldo
 *
 */

public class Player extends GameObject {
	Handler handler;
	Random r  = new Random();
	boolean objectCollides = false;
	static int counter = 0;
	static boolean GameOver = false;
	GameOver gameover;
	
	
	static boolean touchedwall =false;
	static boolean ballmoved = false;
	GameObject playerPlaying;
	 static int distance = SelectDistance.index;


/**
 * constructs a new player object 
 * @param x the x position
 * @param y the y position
 * @param id the type of id the object is 
 * @param handler updates the object 
 */
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler= handler;
	}

	/**
	 * syncs game logic and graphics rendering 
	 */
	public void tick() {
		// TODO Auto-generated method stub
		 x +=  velX;
		 y += velY;
		 x = Game.clamp((int)x, 0, 700);
		 y = Game.clamp((int)y, 0, 700);
		 if (x>=710-10 && velX>0)
			 velX = - velX;
		 if (x<=0 && velX<0)
			 velX = - velX;
		 if (y>=710-10 && velY>0)
			 velY = - velY;
		 if (y<=0 && velY<0)
			 velY = - velY;
		 
		
		 if (MouseInput.player1turn && MouseInput.ballSelected && SelectAngle.selectedAngle && SelectDistance.selectedDistance){
		 			move();
		 			SelectAngle.selectedAngle = false;
 					MouseInput.player1turn=false; 
					MouseInput.player2turn = true;
					MouseInput.ballSelected = false;
					ballmoved = true;
					
		 }
					
				
		 if (ballmoved){
		 collision();
		 
		 
		 }
		 if(objectCollides){
			 DrawShapes.score++;
			objectCollides = false;
		 }
		 
		 
		 
	}
	
	/**
	 * moves the ball selected. 
	 */
	public void move() {
		
		distance = SelectDistance.index;
		int moveballDistance = distance;
		
		System.out.println(distance);
		int angle = SelectAngle.index;
		double degree = (Math.PI/180)*angle;
		
		
		for (int i=0; i<handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID() == ID.Player1){
				
			if(MouseInput.playerX==tempObject.getX()){
				tempObject.getX();
				
		tempObject.setVelX((int) ((int) Math.cos(degree)));
		tempObject.setVelY((int) ((int) Math.sin(degree)));
			
				
		
				}		}
		 }
   }
	
/**
 * checks the collision between the balls 
 */
	private void collision() {
		
		
		for (int i=0; i<handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			
			if (MouseInput.playerX==tempObject.getX() ){
			
				if (tempObject.getID()==ID.Mine){
					if(getBounds().intersects(tempObject.getBounds())){
						handler.removeObject(tempObject);
						objectCollides = true;
					}
					}
			
			if (tempObject.getID()== ID.HappyFace){
				if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(tempObject);
					objectCollides = true;
					DrawShapes.distance  = DrawShapes.distance + 50;
					

				}
			}
			if (tempObject.getID()==ID.Obstacle){
				if(getBounds().intersects(tempObject.getBounds())){
					setVelX(-3);
					setVelY(-3);
					tempObject.setVelX(0);
					tempObject.setVelY(0);
					
				}
			}
			if (tempObject.getID()==ID.Player1){
				if(getBounds().intersects(tempObject.getBounds())){
					setVelX(3);
					setVelY(3);
					tempObject.setVelX(3);
					tempObject.setVelY(3);
					
				}
			}
			if (tempObject.getID()==ID.Player2){
				if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(tempObject);
					objectCollides = true;
					
					
				}
			}
		}
	}
	}
	
	
/**
 * updates my object in the game 
 * @param g graphics g variable 
 */
	public void render(Graphics g) {
		if (DrawShapes.distance<=0)
			GameOver = true;
		if(GameOver)
        	gameover = new GameOver();

		
		if(id ==ID.Player1){
			g.setColor(Color.GREEN);
			g.fillOval((int)x, (int)y, 20, 20);
		}
		
	}
/**
 * return the posiont of the object 
 */
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 20, 20);
	}
	

}
