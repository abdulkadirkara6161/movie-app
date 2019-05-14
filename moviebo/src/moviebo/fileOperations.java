package moviebo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileOperations {
	
	public static void main() {
		 try { 
		      File myfile = new File("C:\\Users\\ABDULKADÝR\\Desktop\\movies.txt"); 
		      if (myfile.createNewFile()) { 
		        System.out.println("File created: " + myfile.getName()); 
		      } else { 
		        System.out.println("File already exists."); 
		      } 
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace(); 
		    } 
		
	}

	public void writeInfo(String director,String movie,String actor,String category,String year) {
		
		try {
			FileWriter myWriter = new FileWriter("C:\\Users\\ABDULKADÝR\\Desktop\\movies.txt",true);
			
			 myWriter.write(director + ":" + movie + ":" + actor+ ":" + category+ ":" + year+"\n");
			 
			
		      
		      myWriter.close();
		      
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<movieInfo> readInfo() {
		String director;
		String movie;
		String actor;
		String category;
		String year;
		
		ArrayList<movieInfo> movielist = new ArrayList<movieInfo>();
		
		String[] array = null;
		 try(Scanner input = new Scanner((Readable) new BufferedReader(new FileReader("C:\\Users\\ABDULKADÝR\\Desktop\\movies.txt")))){
				
				while(input.hasNextLine()) {
					
					String reading = input.nextLine();
					
					array = reading.split(":");
					director = array[0];
					movie = array[1];
					actor = array[2];
					category = array[3];
					year = array[4];
					
					movielist.add(new movieInfo(director, movie, actor, category, year));

				}
				
				
				return movielist;
				
		 } catch (FileNotFoundException e) {
			
			e.printStackTrace();
			return null;
		}
	}
}
