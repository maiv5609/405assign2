import java.util.*;
import java.io.*;

public class maivassign2{
	public static void main(String [] args){
		Scanner	read = new Scanner(System.in);
		String fileName = "inputfile.txt";
		intPair curr = null;
		String firstHalf = null;
		String secondHalf = null;
		Double firstNum = null;
		Double secondNum = null;
		ArrayList<intPair> main = new ArrayList<intPair>();

		String currLine = null;
		String currTok = null;
		FileReader fileReader = null;
		BufferedReader reader = null;
		StringTokenizer tokens = null;

		try{
			fileReader = new FileReader(fileName);
		}catch(FileNotFoundException ex){
			System.out.println("Unable to open file");
		}finally{
			try{
				//Read in input file and store
				reader = new BufferedReader(fileReader);
				while((currLine = reader.readLine()) != null){
					//Break each line into token
					tokens = new StringTokenizer(currLine, " ");
					while(tokens.hasMoreTokens()){
						currTok = tokens.nextToken();
						//Parse number from tokens
						String split[] = currTok.split(",", 2);
						firstHalf = split[0].substring(1);
						secondHalf = split[1].substring(0, split[1].length()-1);
						firstNum = Double.parseDouble(firstHalf);
						secondNum = Double.parseDouble(secondHalf);

						//Add to arraylist
						curr = new intPair(firstNum, secondNum);
						main.add(curr);
					}
				}

				//TODO: Test print, remove this
				for (int i=0; i<main.size(); i++){
					System.out.print((main.get(i)).getEnd()+" ");
				}

				sortbyFinish(main);



				//Note: might need to sort by another condition other than just finishing time
				//Using 2 structures
				//Store initial data
				//Sort by finishing time and put into other structure
				//Start by removing the first interval with the earilest finish time
				//remove next earilest finishing time that doesn't overlap
				//continue until end

				//Begin again with earilest finish time and continue process until no rooms are left, the number of iterations are the number of rooms you need

			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
	/*
	Takes in ArrayList of intPair and sorts intervals by finishing time
	Sorts using mergesort
	 */
	public static void sortbyFinish(ArrayList<intPair> intrList){
		//Look at geeksforgeeks mergesort
		int length = intrList.size();
		int mid = 0;
		int b = 0;
		mid = length/2;
		if((length%2) == 0){
			//even
			//TODO: test print, remove this
			System.out.println("");
			System.out.println("Even");
			b = (length/2);
		}else{
			//odd
			//TODO: test print, remove this
			System.out.println("");
			System.out.println("Odd");
			b = (length/2)+1;
		}

		intPair left[] = new intPair[mid];
		intPair right[] = new intPair[b];

		//TODO: test print, remove this
		System.out.println("");
		System.out.println("Sorting");
		System.out.println("Mid: " + mid);
		System.out.println("b: " + b);
		System.out.println("");

		//Bring over from ArrayList to temps
		for(int x=0; x<mid; x++){
			left[x] = intrList.get(x);
		}
		for(int x=0; x<(length-mid); x++){
			right[x] = intrList.get(x+mid);
		}

		//TODO: test print, remove this
		for(int x=0; x<mid; x++){
			System.out.print(left[x].getEnd() + " ");
		}
		for(int x=0; x<(length-mid); x++){
			System.out.print(right[x].getEnd() + " ");
		}
		System.out.println("");
	}

}

class intPair{
	double start, end, diff;

	intPair(double start, double end){
		this.start = start;
		this.end = end;
		this.diff = end - start;
	}

	public double getStart(){
		return start;
	}
	public double getEnd(){
		return end;
	}
}
