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

				sortbyFinish(main);

				int index = 0;
				int tempSize = 0;
				int classroom  = 0;
				ArrayList<intPair> temp = new ArrayList<intPair>();
				//Start by removing the first interval with the earilest finish time
				//remove next earilest finishing time that doesn't overlap
				//continue until empty
				//Begin again with earilest finish time and continue process until no rooms are left, the number of iterations are the number of rooms you need
				while(!main.isEmpty()){
					if(temp.isEmpty()){
						//if empty remove first
						classroom++;
						curr = main.remove(0);
						temp.add(curr);
						tempSize = temp.size();
					}

					if(main.size() != 0 && (main.get(index)).getStart() >= curr.getEnd()){
						//index event's start time is after or equal curr's end time
						curr = main.remove(index);
						index--;
						temp.add(curr);
						tempSize = temp.size();
					}

					index++;
					//If at last element, print current temp and reset
					if(index == main.size() || main.size() == 0){
						index = 0;
						System.out.println("");
						System.out.print("Classroom " + classroom + ": ");
						for (int i=0; i < temp.size(); i++){
							System.out.print("[" + (temp.get(i)).getStart() + ", " + (temp.get(i)).getEnd() + "] ");
						}
						temp.clear();
					}
				}
				if(classroom == 1){
					System.out.println("\nOne classroom needed");
				}else{
					System.out.println("\n" + classroom + " classrooms needed");
				}

			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
	/*
	Takes in ArrayList of intPair and sorts intervals by finishing time
	Sorts using simple bubblesort
	 */
	public static void sortbyFinish(ArrayList<intPair> intrList){
		int end = intrList.size();
		intPair temp;
		int i = 0;
		boolean swapped = true;

		while(swapped == true && i < (end-1)){
			swapped = false;
			for(int j = 0; j< end-i-1; j++){
					if(intrList.get(j).getEnd() > intrList.get(j+1).getEnd()){
						//bigger, swap
						temp = intrList.get(j);
						intrList.set(j, intrList.get(j+1));
						intrList.set(j+1, temp);
						swapped = true;
					}
			}
			i++;
		}
	}

}

/*
Used to store interval information
*/
class intPair{
	double start, end;

	intPair(double start, double end){
		this.start = start;
		this.end = end;
	}

	public double getStart(){
		return start;
	}
	public double getEnd(){
		return end;
	}
}
