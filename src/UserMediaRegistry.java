import java.time.LocalDateTime;
import java.util.ArrayList;

//importacion modulo LocalDateTime para manejo de las fechas de cada registro

public class UserMediaRegistry {

	//Atributos de clase 
	private static int id;
	private int userId;
	
	private boolean fav;
	private LocalDateTime startDate;
	
	private String urlRef;
	private String name;
	private boolean favorite;
	//Status es un enum
	
	private ArrayList <MediaContent> mediaContent;
	
	public enum ContentType {
		
		TEMPORADA(new Temporada()), SERIE(new Serie()), PLAYLIST(new Playlist()), SAGA(new Saga());
		
		public final MediaContent type;
		
		private ContentType(MediaContent type) {
			this.type = type;
		}
		
		public MediaContent get_type() {
			return type;
		}
	
	}

	//Constructores
	
	public UserMediaRegistry() {
		
	}
	
	public UserMediaRegistry (ContentType type) {
	
		mediaContent.add(type.get_type());
		
	}

	public UserMediaRegistry(int id, String status, boolean fav, String urlRef) {
		this.id = id;
		//this.status = status;
		this.fav = fav;
		this.urlRef = urlRef;
		
	}
	
	
	//Setters y Getters
	//public String getStatus() {
	//	return status;
	//}
	
	//public void setStatus(String status) {
	//	this.status = status;
	//}
	
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
		return id;
	}

	public int getUserId() {
		return userId;
	}
	
	//Logica

	
}