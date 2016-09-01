import java.awt.Graphics;
import java.util.LinkedList;

/**
 * class is going to maintain or update or render my game. loop through game 
 * @author geraldo
 *
 */
public class Handler {
 
	LinkedList<GameObject> object = new LinkedList<GameObject>(); 
	

	/**
	 * sync my game logic and rendering graphics 
	 */
public void tick(){
	for (int i= 0; i <object.size(); i++){
		GameObject tempObject = object.get(i);
		
		tempObject.tick();
	}
	
       }
/**
 * update my game 
 * @param g graphics 
 */
	public void render(Graphics g){
		for (int i= 0; i <object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
	}
		
}
/**
 * add an object
 * @param object gameObject to add 
 */
	public void addObject(GameObject object){
		this.object.add(object);
	}
	/**
	 * remove a gameObject 
	 * @param object gameObject to add
	 */
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
}
