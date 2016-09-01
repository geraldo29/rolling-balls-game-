import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * creates a mine Game object 
 * @author geraldo
 *
 */

public class Mine extends GameObject {
	Handler handler;
	Random r  = new Random();
	public Mine(int x, int y, ID id, Handler handler) {
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
		 y = Game.clamp((int)y, 0, 700);
	}

	/**
	 * updates my game 
	 */
	public void render(Graphics g) {
		
		if(id==ID.Mine){
			g.setColor(Color.RED);
			g.fillOval((int)x, (int)y, 20, 20);
		}
		
		
	}
	/**
	 * gets the positon of the object. 
	 */
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 20, 20);
	}
		
		
	}
