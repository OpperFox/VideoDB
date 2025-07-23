package Logica;
import java.util.ArrayList;

public class UserVideoInfo {

	//Atributos de clase
	private Long videoId;
	private Long userId;
	
	private boolean favorite;
	
	private ArrayList <UserVideoHistory> userVideoHistory;
	
	private Status status;
	private Rating rating;

	//Constructores
	public UserVideoInfo () {
		
		//videoId
		videoId = videoId++;
		
	}
	
	public UserVideoInfo (Rating rating) {
		
		this.rating = rating;
		
	}
	

	//Getters y Setters
	public Long getId() {
		return videoId;
	}

	public Long getUserId() {
		return userId;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public ArrayList<UserVideoHistory> getUserVideoHistory() {
		return userVideoHistory;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "";
		//Devolver toda la informacion del video
	}
	
	
}