import java.time.LocalDateTime;

public class UserVideoHistory {

	private int videoId;
	private int userId;
	private LocalDateTime watchHistory;

	public UserVideoHistory () {
		
	}

	public LocalDateTime getWatchHistory() {
		return watchHistory;
	}

	public void setWatchHistory(LocalDateTime watchHistory) {
		this.watchHistory = watchHistory;
	}

	public int getVideoId() {
		return videoId;
	}

	public int getUserId() {
		return userId;
	}
		
	
}
