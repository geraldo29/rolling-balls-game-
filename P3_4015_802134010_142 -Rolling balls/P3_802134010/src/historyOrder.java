import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * handles the highest score of each player 
 * @author geraldo
 *
 */
public class historyOrder {
	static FileInputStream in; 
    static FileWriter hola; 
    static Scanner fileScanner; 
    static int counter=0;
    JFrame frame = new JFrame("History");

	  static  ArrayList<String> highestScore = new ArrayList<String>();
	    static  ArrayList<String> recentDate = new ArrayList<String>();
	    
	    static  ArrayList<String> username = new ArrayList<String>();
	    static  ArrayList<String> score = new ArrayList<String>();
	    static  ArrayList<String> names = new ArrayList<String>();


	    
	    static String[] columnNames = {"Player 1","Highest Score","Date"};
	     TableModel defaultTable = new DefaultTableModel(columnNames, 100000);
	 JTable table = new JTable(defaultTable){
		
		public boolean isCellEditable (int arg0, int arg1){
			
			return false;
		}};
		
		
	    RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(defaultTable);

	    
	  
	    /**
	     * separates an array into different arrays 
	     */
	    public static void separateArrays(){
	    	for (int i=0;i<username.size();i=i+3)
	    		names.add(username.get(i));
	    	
	    	for (int i=1;i<username.size();i=i+3)
		    	score.add(username.get(i));
		    
	    	for (int i=2;i<username.size();i=i+3)
		    	recentDate.add(username.get(i));
		    
	    }
	    
	    /**
	     * sorts name alphabetically 
	     */
	    public static void sortName(){
	    	
	    	
	    	Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
	    	
	    	 
		}

	    /**
	     * method that reads the file and puts the best score of each player in an array
	     * @return true if file is empty
	     * @throws IOException
	     */
		public static boolean readOnly() throws IOException{ 
	        FileReader p = new FileReader(HistoryFile.file1); 
	        fileScanner  = new Scanner(p); 
	        FileInputStream fileend = new FileInputStream(HistoryFile.file1);
	        
	        username.clear();
	        
	        
	        if (fileend.read() != -1){
	        while(fileScanner.hasNext()) {
	        	String user = fileScanner.next();

	        	String score1 = fileScanner.next();
	        	String user2 = fileScanner.next();
	        	String score2 = fileScanner.next();

	        	String date = fileScanner.nextLine().trim();
	        	
	        	username.add(user);
	        	username.add(score1);
	        	username.add(date);

	        	username.add(user2);

	        	username.add(score2);

	        	username.add(date);
	        	
	 }
	        for (int x =0; x < username.size(); x++) {
		    	System.out.println(username.get(x));
		    }
	        
	        
	        for (int i=0;i<username.size();i = i+3){
    		    for (int x = i + 1; x < username.size(); x++) {
    		  
    			if (username.get(i).equals(username.get(x))) {
    				int a = Integer.parseInt(username.get(i+1));
    				int b = Integer.parseInt(username.get(x+1));
    				if(a >= b){
    					username.remove(x);
    					username.remove(x);
    					username.remove(x);
    					x--;
    					System.out.println(x);
    					
    				}
    				else {
    					username.remove(i);
    					username.remove(i);
    					username.remove(i);
    					i=i-3;
    				}
    			}
    		    }
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
			      * constructs the table and frame to display
			      */
			       
		  public historyOrder(){
			  int counter;
			  try {
					readOnly();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		separateArrays();
			  for(int i=0;i<names.size();i++){
				
				  
				  table.setValueAt(names.get(i), i, 0);

			  }
			  for(int i=0;i<score.size();i++){
				 
				  
				  table.setValueAt(score.get(i), i, 1);

			  }
			  for(int i=0;i<recentDate.size();i++){
				  
				  
				  table.setValueAt(recentDate.get(i), i, 2);

			  }
		    table.setRowSorter(sorter);

		    JScrollPane pane = new JScrollPane(table);
		    frame.add(pane, BorderLayout.CENTER);

		    frame.setSize(500, 500);
		    frame.setVisible(true);
		    }


}

