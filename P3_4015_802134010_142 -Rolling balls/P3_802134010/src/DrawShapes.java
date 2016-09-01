import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


/**
 * Class draws the shapes throught the game
 * @author geraldo
 *
 */


public class DrawShapes extends GameObject {
	
Handler handler;
Game game;
public static int score=0;
public static double distance=1500;
public static int score2 = 0;
public static int distance2=1500;


	
	/**
	 * 
	 * @param x is the x position
	 * @param y is the y position
	 * @param id the kind of object it is drawing
	 * @param handler handles the rendering and the adding of objects
	 */
	public DrawShapes(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;

		// TODO Auto-generated constructor stub
	}
	
	/**
	 * method is to sync game logic and graphics rendering
	 */

	public void tick() {
		// TODO Auto-generated method stub
		 
	}
/**
 * method is to render in the game the shapes and graphics it is creating
 */
	
	public void render(Graphics g) {
		
		
		if(id==ID.Design){
			g.setColor(Color.BLACK);
				
			g.drawLine(game.WIDTH- 1200, game.WIDTH- 480, game.WIDTH- 480, game.WIDTH- 480);
			g.drawLine(game.WIDTH- 480, game.WIDTH- 1200, game.WIDTH- 480, game.WIDTH- 480);
			g.setColor(Color.PINK);
			g.fillRect(game.WIDTH -350, game.WIDTH- 1000, game.WIDTH- 900, game.WIDTH- 1170);
			g.drawRect(game.WIDTH -350, game.WIDTH- 1000, game.WIDTH- 900, game.WIDTH- 1170);
			g.setColor(Color.green);
			g.fillRect(game.WIDTH -350, 230, 300, 30);
			g.drawRect(game.WIDTH -350, 230, 300, 30);
			g.setColor(Color.blue);
			g.fillRect(game.WIDTH -350, 260, 300, 30);
			g.drawRect(game.WIDTH -350, 260, 300, 30);
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 15));
			g.drawString("PLAYER", 855, 220);
			g.drawString("SCORE", 970, 220);
			g.drawString("DISTANCE", 1075,220);
			g.drawString(tester.currentPlayer[0], 855, 250);
			
			
			String s = String.valueOf(score);
			g.drawString(s, 990, 250);
			String d = String.valueOf((int)distance);
			g.drawString(d, 1100, 250);
			
			g.drawString(tester.currentPlayer[1], 855, 280);
			String s2 = String.valueOf(score2);
			g.drawString(s2, 990, 280);
			String d2 = String.valueOf(distance2);
			g.drawString(d2, 1100, 280);
			g.setColor(Color.GREEN);
			g.fillRect(760, 550, 75, 30);
			g.drawRect(760, 550, 75, 30);
			g.setColor(Color.BLUE);
			g.fillRect(760, 640, 75, 30);
			g.drawRect(760, 640, 75, 30);
			g.setColor(Color.BLACK);
			g.drawString("SHOOT", 770,570);
			g.drawString("SHOOT ", 770, 660);
			g.setColor(Color.CYAN);
			g.drawRect(1065,640,85,30);
			g.fillRect(1065, 640, 85, 30);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 12));
			g.drawString("ABORT GAME", 1070,658);
			
			
			
		}
	}

	/**
	 * method that return the bounds of the rectangle. Here it doesnt do anything since we are drawing shapes not gameplay objects.
	 */
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
