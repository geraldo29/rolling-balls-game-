import java.io.BufferedWriter; 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Controls the username and password files.
 * @author geraldo
 *
 */
public class tester {

	
	public static boolean compare = true;

	static FileInputStream in; 
    static FileWriter hola; 
    static Scanner fileScanner; 
    static  ArrayList<String> username = new ArrayList<String>();
    static ArrayList<String> jComboBoxUserName = new ArrayList<String>();
    
  
	static ArrayList<String> jComboBoxPassword = new ArrayList<String>();

    
    static String [] currentPlayer = {"Player1", "Player2"};
    static ArrayList<String> password = new ArrayList<String>();
    static File file1;
    static boolean wroteFile = false;
    static boolean emptyFile =true;

    /**
     * file getter  
     * @return the file  
     */
    public File getFile1() {
		return file1;
	}



    /**
     * file setter 
     * @param file1 is the file you want to set 
     */

	public void setFile1(File file1) {
		this.file1 = file1;
	}
	static String filename = "RegisteredUsers.txt";
    
	 /**
     * getter for username arraylist
     * @return the arraylist 
     */
    public ArrayList<String> getUsername() {
		return username;
	}



/**
 * setter for username arraylist 
 * @param username the arraylist you want to set
 */


	public static void setUsername(ArrayList<String> username) {
		tester.username = username;
	}



	/**
	 * password arraylist getter
	 * @return the arraylist 
	 */

	public ArrayList<String> getPassword() {
		return password;
	}



	/**
	 * password arraylist setter
	 * @param password
	 */

	public static void setPassword(ArrayList<String> password) {
		tester.password = password;
	}

	/**
	 * gets the arraylist 
	 * @return the arraylist gotten 
	 */
	  public static ArrayList<String> getjComboBoxUserName() {
			return jComboBoxUserName;
		}



	  /**
	   * setter for the arraylist 
	   * @param jComboBoxUserName the arraylist setted 
	   */

		public static void setjComboBoxUserName(ArrayList<String> jComboBoxUserName) {
			tester.jComboBoxUserName = jComboBoxUserName;
		}



		/**
		 * getter for the arraylist 
		 * @return the arraylist gotten 
		 */

		public static ArrayList<String> getjComboBoxPassword() {
			return jComboBoxPassword;
		}



/**
 * setter for the arraylist 
 * @param jComboBoxPassword the arraylist to set 
 */

		public static void setjComboBoxPassword(ArrayList<String> jComboBoxPassword) {
			tester.jComboBoxPassword = jComboBoxPassword;
		}
		
		 /**
		    * reads the file created 
		    * @return true if file is empty otherwise it returns false.
		    * @throws IOException
		    */
	public static void createFile(){
		file1  =  new File(filename);
    	try {
			file1.createNewFile();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 /**
     * compare a string if it is in the file 
     * @param user1 the string you are going to compare. 
     * @return false if the string is already in the file otherwise returns true
     * @throws IOException
     */
	 public static boolean compare(String user1) throws IOException{
		 	if (!(readFile())){
     		for (int i =0; i<username.size(); i++)
     			if(!(user1.compareTo(username.get(i))==0))
     				compare =  true;
     				else if(user1.compareTo(username.get(i))==0){
     					compare = false; 
     					return compare;
     				}
		 	}
     		return compare;
		 	
     			
			
}
	 

	   /**
	    * reads the file created 
	    * @return true if file is empty otherwise it returns false.
	    * @throws IOException
	    */

	 public static boolean readFile() throws IOException{ 
         FileReader p = new FileReader(file1); 
         fileScanner  = new Scanner(p); 
         FileInputStream fileend = new FileInputStream(file1);
         
         username.clear();
         password.clear();
         jComboBoxUserName.clear();
         jComboBoxPassword.clear();
         
        if (fileend.read() != -1){
        	emptyFile = false;
         while(fileScanner.hasNextLine()) {
         	String pass = fileScanner.next().trim();
         	String user = fileScanner.nextLine().trim();
         	password.add(pass);
         	username.add(user);

         }
        
         copyArrayList(username,jComboBoxUserName);
         copyArrayList(password, jComboBoxPassword);
         if (Login.player1login){
        	 jComboBoxUserName.remove(Login.indexplayer1);
        	 jComboBoxPassword.remove(Login.indexplayer1);
         }
         if (Login.player2login){
        	 jComboBoxUserName.remove(Login.indexplayer2);
        	 jComboBoxPassword.remove(Login.indexplayer2);
         }
         setUsername(username);
         setPassword(password);
         
         setjComboBoxUserName(jComboBoxUserName);
         setjComboBoxPassword(jComboBoxPassword);
         
        
         p.close(); 
         fileScanner.close(); 
        }
        else {
        	emptyFile = true;
        	compare = true;
        	
        }
        
        
        return emptyFile;
      
     }
	 
	 /**
		 * writes the file 
		 * @param user2 the username you are going to write 
		 * @param pass2 the the password you are going to write 
		 * @throws IOException
		 */
	  public static boolean writeFile(String user2, String pass2) throws IOException{ 
		  
		  
      	FileWriter fileWrite = new FileWriter(file1,true);
      	BufferedWriter writer = new BufferedWriter(fileWrite);
		
      	
      		if (compare(user2)){
      		  writer.append(user2);
      		  writer.append(" ");
              writer.append(pass2);
              writer.newLine();
    		  writer.close();
    		  wroteFile = true;
    		  emptyFile = false;
      		}
      		else wroteFile = false;
      			
      		  return wroteFile;


      	}
	  
	  /**
	   * copy two arraylists 
	   * @param allArray the fist array
	   * @param b the second array 
	   */
	  
	  public static void copyArrayList(ArrayList<String> allArray, ArrayList<String> b){
		  String firstArray;
		  for (int i =0; i<allArray.size(); i++){
			  firstArray = allArray.get(i);
			  b.add(firstArray);
			  
		  }
	  }
	  /**
	   * delete an index from an arraylist
	   * @param jComboArray the arraylist 
	   * @param index the index to be deleted
	   */
		public static void deleteIndex(ArrayList<String> jComboArray, int index){
		
			for (int i =0; i<jComboArray.size(); i++){
				if(index ==i)
				  jComboArray.remove(index);
			}
			
		}
			
}
