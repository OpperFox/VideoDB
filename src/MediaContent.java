import java.util.ArrayList;
//importacion modulo ArrayList

public abstract class MediaContent {

	//Atributos de clase 
	
	private static Long idGlob;
	private Long id_g;
	
	private static int idLoc;
	private int id_l;

	private ArrayList <MediaContent> mediaContent;
	private ArrayList <Video> videos;
	
	private String name;

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

	public Long get_idG() {
		return id_g;
	}

	public int get_idL() {
		return id_l;
	}
	
	public String get_name() {
		return name;
	}
	
	public void set_name(String name) {
		this.name = name;
	}
	
	
	//Logica
	
	public void add_videos() {
	
	}
	
	public void set_video() {
		
	}
	
	public void remove_video() {
		
	}
	
	public void get_video() {
		
	}
	
	public abstract MediaContent add_mediaContent();
	//Series debe contener minimo 1 temporada.
	//Temporada debe contener minimo 1 video.
	//Saga debe contener minimo 1 video.
	//Playlist debe contenter minimo 1 video, pero tambien puede añadir otros MediaContents (ya creados) a la reproduccion como Serie, Temporada, Saga y añadir uno o 
	//varios capitulos (ya creados) de estos.
	
	public abstract MediaContent remove_mediaContent();
	
	//Elimina el media content del array
	
	public abstract MediaContent get_mediaContent();
	
	//Para obetener los videos usar el metodo get_video
	
	//Series debe obtener todas las temporadas si no se indica el indice, si se indica debe obtener tambien sus sucesoras, devuelve el indice usado
	//Temporada debe obtener todos los videos si no se indica el indice, si se indica debe obtener tambien sus sucesores, devuelve el indice usado
	//Playlist debe obtener todos los videos o MediaContent si no se indica el indice, si se indica debe obtener tambien sus sucesores, devuelve el indice usado
	
	public abstract MediaContent set_mediaContent_name();
	
	//Debe permitir cambiar el nombre del media content
	
}