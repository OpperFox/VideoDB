import java.time.LocalDateTime;
import java.util.ArrayList;

//importacion modulo LocalDateTime para manejo de las fechas de cada registro

public class UserMediaRegistry {

	//Atributos de clase 
	private static Long id;
	private Long registryId;
	private Long userId;
	
	private boolean fav;
	private LocalDateTime startDate;
	
	private String urlRef;
	private String name;
	private boolean favorite;
	private ContentType type;
	//Status es un enum
	
	private ArrayList <MediaContent> mediaContent;

	//Constructores
	
	public UserMediaRegistry (Long userId, ContentType type) {
		
		this(userId, type, "NO_NAME");
		
	}
	
	public UserMediaRegistry (Long userId, ContentType type, String name) {
		this(userId, type, name, false);
		//this.name = name;
	}
	
	public UserMediaRegistry (Long userId, ContentType type, String name, boolean fav) {
		
		this(userId, type, name, false, "NO_URL");
		
	}

	public UserMediaRegistry(Long userId, ContentType type, String name, boolean fav, String urlRef) {
		
		registryId = ++id;
		this.userId = userId;
		this.name = name;
		this.fav = fav;
		this.urlRef = urlRef;
		
		this.type = type;
		
		mediaContent = new ArrayList<MediaContent>();
		
		if (this.type != null) {
            mediaContent.add(this.type.get_type());
        }
		
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
	
	public Long getRegistryId() {
		return registryId;
	}

	public Long getUserId() {
		return userId;
	}
	
	//Logica

	
}