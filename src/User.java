
public class User {

	static private int id;
	
	private int userId;
	private String name = null;
	private MediaContent userMedia;

	public User () {
		
	}
	
	public User (String name) {
		
		id++;
		this.userId = id;
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public MediaContent getUserMedia() {
		return userMedia;
	}

	public void setUserMedia(MediaContent userMedia) {
		this.userMedia = new MediaContent ();
	}

	
	
}