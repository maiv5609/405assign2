import java.util.*;
import java.io.*;

public class maivassign2{
	public static	void main(String [] args){
   	Scanner	read = new Scanner(System.in);
   	String fileName = "inputfile.txt";
   
   	try{
   		 fileReader	= new	FileReader(fileName);
   	}catch(FileNotFoundException ex){
   		 System.out.println("Unable to open file");
   	}finally{
   	   try{
   	      //Read in input file, sorting by finishing time
      		reader =	new BufferedReader(fileReader);
      		while((currLine =	reader.readLine()) != null){
      			//Break each line	into token
               //Store input file in data structure as is
      			tokens =	new StringTokenizer(currLine);
      			for(int i =	0;	i <= colNum-1;	i++){
      					 currTok	= tokens.nextToken();
      					 insert = Integer.parseInt(currTok);
                      grid[row][i] = insert;
      			}
      				row++;
      			
      		}
            //Note: might need to sort by another condition other than just finishing time
            //Using 2 structures
               //Store initial data
               //Sort by finishing time and put into other structure
               //Start by removing the first interval with the earilest finish time
               //remove next earilest finishing time that doesn't overlap
               //continue until end
               
            //Begin again with earilest finish time and continue process until no rooms are left, the number of iterations are the number of rooms you need
   		}
   	}
	}
}
