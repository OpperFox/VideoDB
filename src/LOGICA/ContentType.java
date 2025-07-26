package LOGICA;

public enum ContentType { // Define un enumerado que representa tipos de contenido multimedia

	// Cada constante representa un MediaContent diferente
	TEMPORADA("TEMPORADA"), 
	SERIE("SERIE"), 
	PLAYLIST("PLAYLIST"), 
	SAGA("SAGA");// # # # # # mejorar y verificar que se creen correctamente las clases 

	// Campo que almacena la instancia asociada a cada tipo
	public final String typeName;

	// Constructor privado del enum que asigna la instancia al campo 'type'
	private ContentType(String typeName) {
		this.typeName = typeName;
	}

	// Método público para acceder a la instancia asociada al tipo
	@Override
	public String toString() {	
		return typeName;
	}
	
	public MediaContent newType(Long id, Long idAlfa,Long registryId ,int idL) {
		
		switch(this.typeName) {
			case "Temporada":
				return new Temporada(id,idAlfa, idL);
			case "Serie":
				return new Serie(id,registryId, idL);
			case "Playlist":
				return new Playlist(id,registryId, idL);
			case "Saga":
				return new Saga(id,registryId, idL);
			default:
				return null;
		}
		
	}
	
}
