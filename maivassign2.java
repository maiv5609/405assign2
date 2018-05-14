import java.util.*;
import java.io.*;

public class maivassign1{
    public static void main(String [] args){
	Scanner read = new Scanner(System.in);
    String fileName = "SampleDataFile.txt";

	System.out.println("Reading from file: " + fileName);

	try{
	    fileReader = new FileReader(fileName);
	}catch(FileNotFoundException ex){
	    System.out.println("Unable to open file");
	}finally{
	    try{
        //Read in default values into array
		reader = new BufferedReader(fileReader);
		while((currLine = reader.readLine()) != null){
			//Break each line into token
			tokens = new StringTokenizer(currLine);
			for(int i = 0; i <= colNum-1; i++){
                currTok = tokens.nextToken();
                insert = Integer.parseInt(currTok);
			    grid[row][i] = insert;
                //TODO: remove this print statement if not needed
                if(insert<=10){
                    System.out.print(insert + "  ");
                }else{
                    System.out.print(insert + " ");
                }

			}
            row++;
            //TODO: remove this
			System.out.println();
		}
	    }catch(IOException ex){
		ex.printStackTrace();
	    }
	}
}
