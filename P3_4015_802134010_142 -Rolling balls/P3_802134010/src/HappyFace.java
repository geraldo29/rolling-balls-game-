import java.awt.Color;  
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * creates a Happy Face GameObject 
 * @author geraldo
 *
 */

public class HappyFace extends GameObject {
	Handler handler;
	Random r  = new Random();
	
	/**
	 * constructor for happy face 
	 * @param x the x position
	 * @param y the y position
	 * @param id the type it is 
	 * @param handler to render the object 
	 */
	public HappyFace(int x, int y, ID id,Handler handler) {
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
	 * renders or updates through my game 
	 */
	public void render(Graphics g) {
		
		
		if(id==ID.HappyFace){
			g.setColor(Color.YELLOW);
			g.fillOval((int)x,(int) y, 20, 20);
			g.setColor(Color.BLACK);
			g.fillOval((int)x + 5,(int)y+2,5,5);
			g.fillOval((int)x + 10,(int)y+2,5,5);
			g.drawLine((int)x+5,(int) y+15,(int) x+15,(int)y+15);
			g.drawLine((int)x+5, (int)y+15,(int) x+5,(int) y+10);
			g.drawLine((int)x+15, (int)y+15, (int)x+15, (int)y+10);
		}
		
		
		
		
		
		
	}
	/**
	 * get the position of the object 
	 */
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 20, 20);
	}

}