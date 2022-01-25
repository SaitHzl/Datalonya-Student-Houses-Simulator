import java.io.File; 
import java.io.PrintStream;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class project1main {
	public static void main(String[] args) throws FileNotFoundException {
		String inputFileName = args[0]; //taking input file as an argument
		File myInputFile = new File(inputFileName);
		Scanner in = new Scanner(myInputFile);
		String outputFileName = args[1]; //creating output file
		PrintStream out = new PrintStream(new File(outputFileName));
		Allocation allocations = new Allocation();
		//reading data from input file. This part of code stores the data in a list and creates house and student objects accordingly.
		while(in.hasNextLine()) {
			String line = in.nextLine();
			String lineArray[];
			lineArray = line.split(" ");
			if(lineArray[0].equals("h")) {
				House theHouse = new House(Integer.valueOf(lineArray[1]), Integer.valueOf(lineArray[2]), Double.valueOf(lineArray[3]));
				allocations.getHouses().add(theHouse);
	
			}
			if(lineArray[0].equals("s")) {
				Student theStudent = new Student(Integer.valueOf(lineArray[1]), lineArray[2], Integer.valueOf(lineArray[3]), Double.valueOf(lineArray[4]));
				allocations.getStudents().add(theStudent);
				if(theStudent.getDuration()>allocations.getTotalMaxDuration()){{ //If current student's duration is bigger than totalMaxDuration, set totalMaxDuration as current student's duration.
					allocations.setTotalMaxDuration(theStudent.getDuration());
				}
			}
		}
	}
		Collections.sort(allocations.getHouses()); //sorting house list according to houses' ids.
		Collections.sort(allocations.getStudents()); //sorting student list according to students' id.
		allocations.allocations(); //this method allocates students to the houses if they fit.
		Collections.sort(allocations.getGraduated()); //after allocations there exist  graduated students with no home and we sort this list according to students' ids
		for(Student notAllocated : allocations.getGraduated()) { //Lastly, we print these students' names.
				out.print(notAllocated.getName());
				out.println();
		}
		in.close();

}
}
