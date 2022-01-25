
public class House implements Comparable<House> {
	private int id;
	private int duration;
	private double rating;
	public House(int id, int duration, double rating) {
		this.id = id;
		this.duration = duration;
		this.rating = rating;
	}
	public boolean ifEmpty() {
		if(this.duration <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public int compareTo(House e) {
		if(this.id > e.getId()) {
			return 1;
		}
		if(this.id < e.getId()) {
			return -1;
		}
		return 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}
