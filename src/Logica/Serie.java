// Clase Serie que hereda de MediaContent
package Logica;

public class Serie extends MediaContent {
	// Constructor por defecto que llama al constructor de la clase padre
	public Serie(Long id, int loc) {
		super(id);
		
		this.container = false;
		
	}

	// Implementación del método abstracto para agregar contenido subordinado (Temporada)
	@Override
	public MediaContent addMediaContent(Long id, int numMediaContent) {
		// Agrega una nueva instancia de Temporada a la lista de contenidos de la serie
		mediaContent.add(new Temporada(id, numMediaContent));

		// Por ahora devuelve null, se puede mejorar para devolver la temporada creada
		return null;
	}
	
	// Implementación pendiente del método para eliminar un contenido subordinado
	@Override
	public MediaContent removeMediaContent() {
		// Método aún no implementado
		return null;
	}

	// Implementación pendiente del método para obtener un contenido subordinado
	@Override
	public MediaContent getMediaContent() {
		// Método aún no implementado
		return null;
	}

	// Implementación pendiente del método para cambiar el nombre de un contenido subordinado
	@Override
	public MediaContent setMediaContentName(String newName) {
		// Método aún no implementado
		return null;
	}
}
