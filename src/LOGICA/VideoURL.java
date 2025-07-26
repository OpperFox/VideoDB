package LOGICA;
public class VideoURL {
	
	//Atributos de clase
	private Long videoId;
	private String urlList;	

	//Constructores
	public VideoURL () {
		
	}
	
	public VideoURL (Long videoId, String urlList) {
		
		this.videoId = videoId;
		this.urlList = urlList;
		
	}
	

	//Setters y Getters
	public String getURL_list() {
		return urlList;
	}

	public void setURL_list(String urlList) {
		this.urlList = urlList;
	}

	public Long getVideo_Id() {
		return videoId;
	}
	
	
}