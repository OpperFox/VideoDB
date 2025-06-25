
public enum ContentType { // Define un enumerado que representa tipos de contenido multimedia

	// Cada constante representa un MediaContent diferente
	TEMPORADA(new Temporada()), SERIE(new Serie()), PLAYLIST(new Playlist()), SAGA(new Saga());// # # # # # mejorar y verificar que se creen correctamente las clases 

	// Campo que almacena la instancia asociada a cada tipo
	public final MediaContent type;

	// Constructor privado del enum que asigna la instancia al campo 'type'
	private ContentType(MediaContent type) {
		this.type = type;
	}

	// Método público para acceder a la instancia asociada al tipo
	public MediaContent get_type() {
		return type;
	}
}
