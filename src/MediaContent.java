import java.util.ArrayList;
//importacion modulo ArrayList

public abstract class MediaContent {

	//Atributos de clase 
	
	protected static Long idGlob;
	protected Long id_g;
	
	protected static int idLoc;
	protected int id_l;

	protected ArrayList <MediaContent> mediaContent;
	protected ArrayList <Video> videos;
	
	protected String name;

	//Constructores
	
	public MediaContent () {
		this("NO_NAME");
	}
	
	public MediaContent (String name) {
		this(name, 1);
		//this.name = name;
	}
	
	public MediaContent (String name, int entryNum) {
		this(name, entryNum, 6);
	}
	
	public MediaContent (String name, int entryNum, int videoNum) {
		
		//idGlob = numero de MediaContent en la base de datos que son del mismo tipo
		this.id_g = ++idGlob;
		//idLoc = numero de MediaContent dentro de este objeto - setear a 0 despues de finalizar la creacion del registro
		this.id_l = ++idLoc; 
		this.name = name;
		mediaContent = new ArrayList <MediaContent>(entryNum);
		videos = new ArrayList <Video>(videoNum);
		
	}
	
	//Setters y Getters

	public Long getIdG() {
		return id_g;
	}

	public int getIdL() {
		return id_l;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	//Logica
	
	public void addVideos() {
	
	}
	
	public void setVideo() {
		
	}
	
	public void removeVideo() {
		
	}
	
	public void getVideo() {
		
	}
	
	public abstract MediaContent addMediaContent(int numMediaContent);
	//Series debe contener minimo 1 temporada.
	//Temporada debe contener minimo 1 video.
	//Saga debe contener minimo 1 video.
	//Playlist debe contenter minimo 1 video, pero tambien puede añadir otros MediaContents (ya creados) a la reproduccion como Serie, Temporada, Saga y añadir uno o 
	//varios capitulos (ya creados) de estos.
	
	public abstract MediaContent removeMediaContent();
	
	//Elimina el media content del array
	
	public abstract MediaContent getMediaContent();
	
	//Para obetener los videos usar el metodo get_video
	
	//Series debe obtener todas las temporadas si no se indica el indice, si se indica debe obtener tambien sus sucesoras, devuelve el indice usado
	//Temporada debe obtener todos los videos si no se indica el indice, si se indica debe obtener tambien sus sucesores, devuelve el indice usado
	//Playlist debe obtener todos los videos o MediaContent si no se indica el indice, si se indica debe obtener tambien sus sucesores, devuelve el indice usado
	
	public abstract MediaContent setMediaContentName(String newName);
	
	//Debe permitir cambiar el nombre del media content
	
}