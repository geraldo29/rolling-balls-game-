import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;


/**
 * makes a new player object 
 * @author geraldo
 *
 */
public class Player2 extends GameObject {
	Handler handler;
	Random r  = new Random();
	boolean objectCollides = false;
	
	/**
	 * constructs a new player2 object 
	 * @param x  the x position
	 * @param y the y position
	 * @param id the type of player the object is 
	 * @param handler updates the object 
	 */
	public Player2(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler= handler;
	}
	
	/**
	 * syncs game logic and rendering graphics 
	 */

	public void tick() {
		// TODO Auto-generated method stub
		 x += velX;
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
		 
		 
		 if (MouseInput.player2turn && MouseInput.ballSelected2 && SelectAngle.selectedAngle){
				move();
	 			SelectDistance.selectedDistance= false;

				SelectAngle.selectedAngle=false;
				MouseInput.player2turn=false; 
				MouseInput.player1turn = true;
				MouseInput.ballSelected2 = false;
	 }

		 collision();
		 if(objectCollides){
			 DrawShapes.score2++;
			 DrawShapes.distance2--;

			objectCollides = false;
		 }

	}

	/**
	 * moves the player 
	 */
	public void move() {
		int distance = SelectDistance.index;
	System.out.println(distance);
	int angle = SelectAngle.index;
	double degree = (Math.PI/180)*angle;
	
	
	for (int i=0; i<handler.object.size();i++){
		GameObject tempObject = handler.object.get(i);
		
		if (tempObject.getID() == ID.Player2){
			
		if(MouseInput.playerX==tempObject.getX()){
			tempObject.getX();
			
	tempObject.setVelX((int) ((int) Math.cos(degree)));
	tempObject.setVelY((int) ((int) Math.sin(degree)));
		
			
	
			}		}
	 }
}

	/**
	 * checks collision with other balls 
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
				
				if (tempObject.getID()== ID.Player1){
					if(getBounds().intersects(tempObject.getBounds())){
						handler.removeObject(tempObject);
						objectCollides = true;
						
					}
			
			if (tempObject.getID()== ID.Mine){
				if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(tempObject);
					objectCollides = true;
					
				}
			}
			if (tempObject.getID()== ID.HappyFace){
				if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(tempObject);
					objectCollides = true;

				}
			}
			if (tempObject.getID()==ID.Obstacle){
				if(getBounds().intersects(tempObject.getBounds())){
					setVelX(3);
					setVelY(3);
					tempObject.setVelX(0);
					tempObject.setVelY(0);
					
				}
			}
			if (tempObject.getID()==ID.Player2){
				if(getBounds().intersects(tempObject.getBounds())){
					setVelX(3);
					setVelY(3);
					tempObject.setVelX(1);
					tempObject.setVelY(1);
					
				}
			}
		}
	}}
	}

	/**
	 * updates my game 
	 */
	public void render(Graphics g) {
		
		
		if (id==ID.Player2){
			g.setColor(Color.BLUE);
			g.fillOval((int)x, (int)y, 20, 20);
		}
		
		
		
		
		
		
	}

	/**
	 * returns the objects position
	 */
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 20, 20);
	}
	

}