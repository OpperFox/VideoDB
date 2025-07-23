package Logica;
import java.util.ArrayList;
// Importación del módulo ArrayList para manejar colecciones dinámicas de objetos

public abstract class MediaContent {

	// Atributos de clase compartidos por todas las instancias
	protected static Long idGlob; // Contador global de MediaContent a nivel de sistema (para asignar IDs únicos)
	protected static int idLoc;   // Contador local para controlar cuántos contenidos se han creado dentro de una misma jerarquía

	// Atributos de instancia
	protected Long id_g; // ID global único de este objeto
	protected int id_l;  // ID local relativo dentro de su jerarquía o grupo

	protected ArrayList<MediaContent> mediaContent; // Lista de MediaContent subordinados (ej. temporadas dentro de una serie)
	protected ArrayList<Video> videos;              // Lista de objetos Video asociados a este contenido

	protected String name; // Nombre del contenido (serie, temporada, etc.)

	protected boolean container;
	
	// Constructores

	// Constructor por defecto que asigna un nombre por defecto
	public MediaContent () {
		
		this("NO_NAME");
	}

	// Constructor que permite establecer el nombre
	public MediaContent (String name) {
		this(name, 1); // Asume por defecto 1 entrada subordinada
	}

	// Constructor que permite establecer nombre y número de elementos subordinados
	public MediaContent (String name, int entryNum) {
		this(name, entryNum, 6); // Por defecto asigna capacidad para 6 videos
	}

	// Constructor principal con todos los parámetros
	public MediaContent (String name, int entryNum, int videoNum) {
		// Asigna ID global único incrementando el contador compartido
		this.id_g = ++idGlob;

		// Asigna ID local único incrementando el contador compartido
		this.id_l = ++idLoc;

		// Asigna el nombre del contenido
		this.name = name;

		// Inicializa la lista de contenidos con capacidad inicial
		if(container = true) mediaContent = new ArrayList<MediaContent>(entryNum);

		// Inicializa la lista de videos con capacidad inicial
		videos = new ArrayList<Video>(videoNum);
	}

	// Getters y Setters

	public Long getIdG() {
		return id_g; // Devuelve el ID global del objeto
	}

	public int getIdL() {
		return id_l; // Devuelve el ID local del objeto
	}

	public String getName() {
		return name; // Devuelve el nombre del contenido
	}
	
	public boolean isContainer() {
		return container;
	}

	public void setName(String name) {
		this.name = name; // Permite modificar el nombre del contenido
	}

	// Métodos relacionados con los videos (aún sin implementar)

	public void addVideos() {
		// Lógica pendiente para agregar videos al contenido
	}

	public void setVideo() {
		// Lógica pendiente para modificar un video existente
	}

	public void removeVideo() {
		// Lógica pendiente para eliminar un video de la lista
	}

	public void getVideo() {
		// Lógica pendiente para recuperar un video (por índice o criterio)
	}

	// Métodos abstractos a ser implementados

	// Permite agregar uno o más contenidos a este contenido
	public abstract MediaContent addMediaContent(int numMediaContent);

	/*
		- Serie debe contener al menos 1 temporada
		- Temporada debe contener al menos 1 video
		- Saga debe contener al menos 1 video
		- Playlist puede contener videos o también MediaContents como Saga, Serie, etc.
	*/

	// Elimina un contenido del arreglo
	public abstract MediaContent removeMediaContent();

	// Recupera un contenido (por índice o contexto)
	public abstract MediaContent getMediaContent();

	/*
		- Serie: devuelve todas las temporadas, o a partir de un índice (y las siguientes)
		- Temporada: devuelve todos los videos o desde un índice hacia adelante
		- Playlist: devuelve todos los contenidos o desde un índice, ya sean videos o MediaContents
	*/

	// Permite modificar el nombre de un contenido 
	public abstract MediaContent setMediaContentName(String newName);
}
