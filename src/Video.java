
public class Video {

	static private int id;
	private int videoId;
	private int position;
	private String name = null;
	
	

	public Video () {
		
	}
	
	public Video (int position) {
		
		id++;
		this.videoId = id;
		this.position = position;
		
	}
	
	public Video (int position, String name) {
		
		this.position = position;
		this.name = name;
		
	}

	
	
	public int getId() {
		return videoId;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}