import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter; 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;

/**
 * handles the history file. history of games
 * @author geraldo
 *
 */

public class HistoryFile extends JFrame{
	static int counter = 0;
	static int n=0; 
	static int m=0;
	public static boolean mostRecent = false;
	static JFrame frame;
	static FileInputStream in; 
    static FileWriter hola; 
    static Scanner fileScanner; 
    static  ArrayList<String> score = new ArrayList<String>();
    static ArrayList<String> date = new ArrayList<String>();
 


    
    static String[] columnNames = {"Player 1","Score 1","Player 2","Score 2","Date"}; 

	
	static DefaultTableModel defaultTable = new DefaultTableModel(columnNames, 100000);
	static JTable table = new JTable(defaultTable){
		
		public boolean isCellEditable (int arg0, int arg1){
			
			return false;
		}};

		static JScrollPane pane = new JScrollPane(table);

	static String filename = "History.txt";

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
 * setter for the file
 * @param file1 the file to set 
 */
	public void setFile1(File file1) {
		this.file1 = file1;
	}
    /**
     * getter for the score arraylist 
     * @return score 
     */
    public ArrayList<String> getScore() {
		return score;
	}




/**
 * setter for the score arraylist 
 * @param score the score you will set 
 */
	public static void setScore(ArrayList<String> score) {
		HistoryFile.score = score;
	}




/**
 * getter for date 
 * @return the date 
 */
	public ArrayList<String> getDate() {
		return date;
	}




/**
 * date setter 
 * @param date the date you will set 
 */
	public static void setDate(ArrayList<String> date) {
		HistoryFile.date = date;
	}
	/**
	 * creates a file 
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
	 * reads the file 
	 * @param table updates the table 
	 * @return true if file is empty. false if otherwise 
	 * @throws IOException
	 */
	public static boolean readFile(JTable table) throws IOException{ 
        FileReader p = new FileReader(file1); 
        fileScanner  = new Scanner(p); 
        FileInputStream fileend = new FileInputStream(file1);
        
        
        
        if (fileend.read() != -1){
        while(fileScanner.hasNext()) {
        	counter++;
        	String user = fileScanner.next();
        	String score = fileScanner.next();
        	String user2 = fileScanner.next();
        	String score2 = fileScanner.next();
        	String date = fileScanner.nextLine();
           
        	table.setValueAt(user, n,	m);
    		table.setValueAt(score, n,	m = m+1);
    		table.setValueAt(user2, n,	m = m+1);
    		table.setValueAt(score2, n,m=	m+1);
    		table.setValueAt(date, n,	m=m+1);
    		n++;
    		m=0;
    			
        	
        }
        
        
        p.close(); 
        fileScanner.close(); 
        return true;
        }   
        else {
        	p.close();
        	fileScanner.close();
        	return false;
        }
        
         
     
    }
	
	/**
	 * writes to file the game that was played 
	 * @param user1 the player1  
	 * @param score1 score for player 1
	 * @param user2 player 2
	 * @param score2 score for player 2
	 * @param dateR the date it was played 
	 * @throws IOException
	 */
	
	  public static void writeFile(String user1, int score1,  String user2, int score2, String dateR) throws IOException{ 
		  
		  
      	FileWriter fileWrite = new FileWriter(file1,true);
      	BufferedWriter writer = new BufferedWriter(fileWrite);
			
			
			readFile(table);

      		  writer.append(user1);
      		  writer.append("      ");
              writer.append("      "+score1);
              writer.append("            ");
              writer.append(user2);
      		  writer.append("            ");
              writer.append("     " +score2);
              writer.append("      " +dateR);
              writer.newLine();
    		  writer.close();
    		  
    		 
  			table.getTableHeader().setReorderingAllowed(Boolean.FALSE);
  			table.getColumn(columnNames[4]).setPreferredWidth(100);
  			
  			
  			n = counter;
  			
    		table.setValueAt(user1, n,	m);
    		table.setValueAt(score1, n,	m = m+1);
    		table.setValueAt(user2, n,	m = m+1);
    		table.setValueAt(score2, n,m=	m+1);
    		table.setValueAt(dateR, n,	m=m+1);
    		counter++;
    		m=0;
    			
    		
		
      	}
	  
	  /**
	   * prints out the table in a JFrame. 
	   */

static public void ShowTable(){
	 
		frame = new JFrame("All GAMES PLAYED");

		frame.add(pane);
		frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

	  }
}