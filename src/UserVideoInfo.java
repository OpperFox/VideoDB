
public class UserVideoInfo {

	private int videoId;
	private double rating;

	public UserVideoInfo () {
		
	}
	
	public UserVideoInfo (double rating) {
		
		this.rating = rating;
		
	}

	public int getVideoId() {
		return videoId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
}
