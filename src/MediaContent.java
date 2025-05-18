import java.time.LocalDateTime;

public class MediaContent {

	private int videoId;
	private int userId;
	//private object contentType<array>;
	private boolean fav;
	private LocalDateTime startDate;
	
	private String urlRef;
	private String status;
	

	
	public MediaContent () {
		
	}
	
	public MediaContent (int videoId, String status) {
		
		this.videoId = videoId;
		this.status = status;
		
	}

	public MediaContent (int videoId, String status, boolean fav) {
	
		this.videoId = videoId;
		this.status = status;
		this.fav = fav;		
		
	}

	public MediaContent(int videoId, String status, boolean fav, String urlRef) {
		this.videoId = videoId;
		this.status = status;
		this.fav = fav;
		this.urlRef = urlRef;
		
	}
	
	

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean isFav() {
		return fav;
	}
	
	public void setFav(boolean fav) {
		this.fav = fav;
	}
	
	public LocalDateTime getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
	public String getUrlRef() {
		return urlRef;
	}
	
	public void setUrlRef(String urlRef) {
		this.urlRef = urlRef;
	}
	
	public int getVideoId() {
		return videoId;
	}

	public int getUserId() {
		return userId;
	}

	
}
