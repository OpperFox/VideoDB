package LOGICA;
import java.util.ArrayList;
// Importa ArrayList para manejar una colección dinámica de URLs asociadas al video

public class Video {
	
	// Atributos de clase
	
	static private Long id; // Contador estático para generar un ID único para cada video
	
	//Identificadores relacionados con la jerarquia del MediaContent // # # # # # Revisar que funcione y no se deban crear nuevas variables o implementarlo de otra forma 
	private Long sigmaMediaContent; // ID del contenido contenedor mas alto (por ejemplo, Saga, Playlist o Serie)
	private Long alfaMediaContent;  // ID del contenido contenedor más bajo (por ejemplo Temporada)
	
	private Long videoId;     // ID único del video generado a partir del contador
	private int position = 0;     // Posición del video dentro de su lista o secuencia
	private String name = null; // Nombre del video
	
	private ArrayList<VideoURL> videoURL; // Lista de URLs asociadas al video

	// Constructores
	
	public Video (Long sigma, Long alfa, Long id, int position) {
		// Constructor por defecto
		// Llama al constructor que recibe un nombre
		this(sigma, alfa,id, position, "Video "+ position); // El nombre será una combinación del contenido superior (sigma + alfa) si el usuario no lo llena
	}
	
	// # # # # # implementar correctamente los constructores como en las clases anteriores 
	
	public Video (Long sigma, Long alfa, Long id, int position, String name) {
		// Constructor que recibe un nombre y genera automáticamente el ID del video
		                // Incrementa el contador global
		this.videoId = id;   // Asigna el nuevo ID al video
		this.position += position;
		this.name = name;
		
		this.alfaMediaContent = alfa;
		this.sigmaMediaContent = sigma;
	}

	// Getters y Setters
	
	public Long getId() {
		return videoId; // Devuelve el ID único del video
	}

	public int getPosition() {
		return position; // Devuelve la posición del video
	}

	public void setPosition(int position) {
		this.position = position; // Permite modificar la posición
	}

	public String getName() {
		return name; // Devuelve el nombre del video
	}

	public void setName(String name) {
		this.name = name; // Permite modificar el nombre del video
	}
}
