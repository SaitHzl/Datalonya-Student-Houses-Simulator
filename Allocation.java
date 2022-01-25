import java.util.Iterator;
import java.util.LinkedList;


public class Allocation {
	private LinkedList<Student> students; //keeping students in a linkedlist.
	private LinkedList<House> houses; //keeping houses in a linkedlist.
	private LinkedList<Student> graduated; //keeping graduated students with no allocation in a linkedlist.
	private int totalMaxDuration; //the highest remaining semester that a student has in the simulation.
	public Allocation() {
		this.students = new LinkedList<Student>();
		this.houses = new LinkedList<House>();
		this.totalMaxDuration = 0;
		this.graduated = new LinkedList<Student>();
	}
	public void allocations() { 
		for(int i = 0; i < totalMaxDuration; i++) { //iterating for highest remaining semester.
			Iterator<Student> studentValue = students.iterator();
			while(studentValue.hasNext()) {//checking each student wheter they get home or not.
				Student currentStudent = studentValue.next();
				for(House currentHouse : houses){ //checking every house if there is a good one.
					if(currentStudent.getRating() <= currentHouse.getRating() && currentHouse.ifEmpty() && currentStudent.getDuration() > 0) {
						currentHouse.setDuration(currentStudent.getDuration());
						currentStudent.setDuration(0);
						currentStudent.setStudentsHouse(currentHouse);
						break;
					}
					
				}
				if(currentStudent.getDuration() > 0) { // decreasing every student's duration 1 at the end of the semester.
					currentStudent.setDuration(currentStudent.getDuration()-1);
				}
				if(currentStudent.getDuration() <= 0 && !currentStudent.ifAllocated()) { //checking if the student graduate or not. If s/he graduate ,then check for allocation. If s/he is not allocated in a house add her/him to the graduated list.
					graduated.add(currentStudent);
					studentValue.remove();
				}
				if(currentStudent.getDuration() <= 0 && currentStudent.ifAllocated()) { // If a student is located in a house remove him/her from the student list.
					studentValue.remove();
				}
			}
		for(House updateHouse : houses) { // decreasing every house's duration 1 at the end of the semester.
			updateHouse.setDuration(updateHouse.getDuration()-1);
		}
		if(students.isEmpty()) { // If all students graduate then the simulation ends.
			break;
		}
		}
	}
	public int getTotalMaxDuration() {
		return totalMaxDuration;
	}
	public void setTotalMaxDuration(int totalMaxDuration) {
		this.totalMaxDuration = totalMaxDuration;
	}
	public LinkedList<Student> getStudents() {
		return students;
	}
	public void setStudents(LinkedList<Student> students) {
		this.students = students;
	}
	public LinkedList<House> getHouses() {
		return houses;
	}
	public void setHouses(LinkedList<House> houses) {
		this.houses = houses;
	}
	public LinkedList<Student> getGraduated() {
		return graduated;
	}
	
}
