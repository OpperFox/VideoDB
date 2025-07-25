package Logica;
import java.util.ArrayList;
// Importación del módulo ArrayList para manejar colecciones dinámicas de objetos

public abstract class MediaContent {

	// Atributos de clase compartidos por todas las instancias
	protected static Long idGlob; // Contador global de MediaContent a nivel de sistema (para asignar IDs únicos)
	protected static int idLoc;   // Contador local para controlar cuántos contenidos se han creado dentro de una misma jerarquía

	// Atributos de instancia
	protected Long id_g; // ID global único de este objeto
	protected int id_l = -1;  // ID local relativo dentro de su jerarquía o grupo
	
	protected Long registryId;

	protected ArrayList<MediaContent> mediaContent; // Lista de MediaContent subordinados (ej. temporadas dentro de una serie)
	protected ArrayList<Video> videos;              // Lista de objetos Video asociados a este contenido
	
	protected String alfa;
	protected String beta;

	protected String name; // Nombre del contenido (serie, temporada, etc.)
	
	protected int videoNum;

	protected boolean container;
	
	// Constructores

	// Constructor por defecto que asigna un nombre por defecto
	public MediaContent (Long id_g, Long registryId) {
		
		this(id_g, registryId, "NO_NAME");
	}

	// Constructor que permite establecer el nombre
	public MediaContent (Long id_g, Long registryId, String name) {
		this(id_g, registryId ,name, 1); // Asume por defecto 1 entrada subordinada
	}

	// Constructor que permite establecer nombre y número de elementos subordinados
	public MediaContent (Long id_g,Long registryId, String name, int id_l) {
		this(id_g, registryId, name, id_l, 1); // Por defecto asigna capacidad para 6 videos
	}

	// Constructor principal con todos los parámetros
	public MediaContent (Long id_g, Long registryId,  String name, int id_l, int videoNum) {
		// Asigna ID global único incrementando el contador compartido
		this.id_g = id_g;
		this.registryId = registryId;
		// Asigna ID local único incrementando el contador compartido
		if(container == false) {
			this.id_l = id_l;
			this.videoNum = videoNum;
		}

		// Asigna el nombre del contenido
		this.name = name;
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
	
	public static String alfa_betaCreator (Long id, int limit) {
		
		String x = "";
		
		for(int i = 0; i < limit; i++) {
			
			x += 'a'+String.valueOf(id+i);
			
		}
		
		return x;
	}
	
	public static Long[] alfa_betaReader(String alfa_beta) {
		
	    String[] list = alfa_beta.split("a");

	    // Filtrar vacíos y contar cuántos números válidos hay
	    int count = 0;
	    for (String s : list) {
	        if (!s.isEmpty()) count++;
	    }

	    Long[] listf = new Long[count];
	    int x = 0;
	    
	    for (String i : list) {
	        if (!i.isEmpty()) {
	            listf[x] = Long.valueOf(i);
	            x++;
	        }
	    }

	    return listf;
	}

	public static int alfa_betaAsigner(Long[] list, Long id) {
		
		for(int i = 0; i < list.length;i++) {
			if(list[i] == id) return i;
		}
		
		return -1;
	}
	

	// Métodos abstractos a ser implementados

	// Permite agregar uno o más contenidos a este contenido
	public abstract MediaContent addMediaContent(Long id, Long registryId ,int numMediaContent);

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
