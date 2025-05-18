
public class VideoURL {
	
	private int videoId;
	private String urlList;	

	public VideoURL () {
		
	}
	
	public VideoURL (int videoId, String urlList) {
		
		this.videoId = videoId;
		this.urlList = urlList;
		
	}

	public String getURL_list() {
		return urlList;
	}

	public void setURL_list(String urlList) {
		this.urlList = urlList;
	}

	public int getVideo_Id() {
		return videoId;
	}
	
	
}
