import java.util.ArrayList;

public class Video {
	//Atributos de la clase
	static private Long id;
	
	private Long sigmaMediaContent;
	private Long alfaMediaContent;
	
	private Long videoId;
	private int position;
	private String name = null;
	
	private ArrayList <VideoURL> videoURL;
	
	
	//Constructores
	public Video () {
		
		this("");//rellenar con el nombre del mediacontent sigma + el nombre del mediacontent alfa (si existe)
		
	}
	
	public Video (String name) {
		
		id++;
		this.videoId = id;
		this.position = position;
		
	}
	
	public Video (int position, String name) {
		
		this.position = position;
		this.name = name;
		
	}

	
	//Setters y Getters
	public Long getId() {
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