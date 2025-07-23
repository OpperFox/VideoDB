package Logica;

public enum ContentType { // Define un enumerado que representa tipos de contenido multimedia

	// Cada constante representa un MediaContent diferente
	TEMPORADA(new Temporada(), "Temporada"), 
	SERIE(new Serie(), "Serie"), 
	PLAYLIST(new Playlist(), "Playlist"), 
	SAGA(new Saga(), "Saga");// # # # # # mejorar y verificar que se creen correctamente las clases 

	// Campo que almacena la instancia asociada a cada tipo
	public final MediaContent type;
	public final String typeName;

	// Constructor privado del enum que asigna la instancia al campo 'type'
	private ContentType(MediaContent type, String typeName) {
		this.type = type;
		this.typeName = typeName;
	}

	// Método público para acceder a la instancia asociada al tipo
	public MediaContent getType() {
		return type;
	}
	
}
