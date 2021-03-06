public class Student implements Comparable<Student> {
	private int id;
	private String name;
	private int duration;
	private double rating;
	private House studentsHouse;
	public Student(int id, String name, int duration, double rating) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.rating = rating;
		this.studentsHouse = null;
	}
	public int compareTo(Student e) {
		if(this.id > e.getId()) {
			return 1;
		}
		if(this.id < e.getId()) {
			return -1;
		}
		return 0;
	}
	public boolean ifAllocated() {
		if(this.studentsHouse == null) {
			return false;
		}
		else {
			return true;
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public House getStudentsHouse() {
		return studentsHouse;
	}
	public void setStudentsHouse(House studentsHouse) {
		this.studentsHouse = studentsHouse;
	}
	
	
}