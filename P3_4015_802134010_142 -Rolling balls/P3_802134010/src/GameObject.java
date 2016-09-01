import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * abstract class used to construct my game objects 
 * @author geraldo
 *
 */
public abstract class GameObject {

	float x;
	float y;
	protected int z;
	protected ID id; 
	protected int velX, velY;
	
	/**
	 * constructs game objects
	 * @param x the x position 	
	 * @param y the y position
	 * @param id the type of object it is 
	 */
	public GameObject(int x, int y, ID id ){
		this.x = x; 
		this.y = y; 
		this.id = id;
	}
	/**
	 * sync game logic and graphics rendering
	 */
	public abstract void tick();
	/**
	 *  renders my game graphics updates. 
	 */
	public abstract void render(Graphics g); 
	/**
	 * get the posion of the object 
	 * @return
	 */
	public abstract Rectangle getBounds();
	/**
	 * setter for x position 
	 * @param f the postion to set 
	 */
	
	
	public void setX(float f){
		this.x = f;
	}
	/**
	 * setter for y position 
	 * @param f
	 */
	public void setY(float f){
		this.y = f;
	}
/**
 * getter for x position 
 * @return
 */
	public float getX(){
		return x;
	}
	
	/**
	 * getter for x position 
	 * @return
	 */
	public float getY(){
		return y;
	}
	/**
	 * setter for id 
	 * @param id type of object it will be
	 */
	public void setID(ID id){
		this.id = id;
	}
	/**
	 * getter  for id 
	 * @return
	 */
	public ID getID(){
		return id;
	}
	
	/**
	 * setter for velocity for x 
	 * @param velX the velocity to set 
	 */
	public void setVelX(int velX){
		this.velX= velX; 
	}
	/**
	 * setter for velocity for y 
	 * @param velY the velocity to set
	 */
	public void setVelY(int velY){
		this.velY = velY;
	}
	/**
	 * getter for velocity x
	 * @return the velocity
	 */
	public int getVelX(){
		return velX; 
	}
	/**
	 * getter for velocity y 
	 * @return the volocity y 
	 */
	public int getVelY (){
		return velY;
	}
}
