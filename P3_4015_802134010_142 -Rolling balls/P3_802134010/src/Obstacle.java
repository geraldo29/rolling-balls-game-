import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * creates an obstacle gameobject 
 * @author geraldo
 *
 */
public class Obstacle extends GameObject {
	Handler handler;
	Random r  = new Random();
	
	/**
	 * constructor of obstacle 
	 * @param x  the x position 
	 * @param y the y position
	 * @param id the type of game object
	 * @param handler updates the object during game
	 */
	public Obstacle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	/**
	 * syncs game logic and rendering graphics 
	 */
	public void tick() {
		// TODO Auto-generated method stub
		 x += velX;
		 y += velY;
		 x = Game.clamp((int)x, 0, 700);
		 y = Game.clamp((int)y, 0,700);
	}

	
	/**
	 * updates my graphics in game 
	 */
	public void render(Graphics g) {
		
		if(id==ID.Obstacle){
			g.setColor(Color.BLACK);
			g.fillOval((int)x,(int) y, 20, 20);
		}
		
		
	}
	
	/**
	 * returns the postion of the object.
	 */
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 20, 20);
	}
	
	

}