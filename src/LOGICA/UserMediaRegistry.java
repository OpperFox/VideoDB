package LOGICA;
import java.time.LocalDateTime;
import java.util.ArrayList;

// Importación del módulo LocalDateTime para manejo de fechas
// Importación de ArrayList para manejar listas de contenido multimedia

public class UserMediaRegistry {

	// Atributos de instancia
	private Long registryId; // ID único del registro de contenido
	private Long userId;     // ID del usuario al que pertenece este registro

	private boolean fav;     // Marca si este contenido fue marcado como favorito
	private LocalDateTime startDate; // Fecha de inicio de visualización o registro
	
	private String urlRef;   // Referencia a una URL asociada al contenido (por ejemplo, imagen o enlace)
	private String name;     // Nombre del contenido registrado
	private ContentType type; // Tipo de contenido (Serie, Temporada, etc.)
	private Status status;
	private Rating rating;

	private MediaContent mediaContent; // Lista que almacena el contenido multimedia asociado

		// Constructor principal que inicializa todos los atributos esenciales
		public UserMediaRegistry(
				Long userId,
				ContentType type,
				String name,				
			    Status status,
			    String urlRef,
			    Rating rating,
				boolean fav			   			    			    			   
			) {
			
			//id consulta DB
			this.userId = userId;
			this.name = name;
			this.fav = fav;
			this.urlRef = urlRef;
			this.type = type;
			this.status = status;

			this.startDate = LocalDateTime.now(); //cambiar para que la hora sea ingresada por la base de datos
			
		}

		// Métodos de acceso (getters y setters)

		public void newMediaContent(Long id, Long idAlfa, Long registryId, int loc) {
			
			switch (type) {
				case SERIE:
					mediaContent = new Serie(registryId, registryId, loc);
					break;
				case PLAYLIST:
					mediaContent = new Playlist(registryId, registryId, loc);
					break;
				case SAGA:
					mediaContent = new Saga(registryId, registryId, loc);
					break; 
			}
			
		}
		
		public void newMediaContent(Long id, Long idAlfa, Long registryId, int loc, String name, int  videoNum) {
			
		}
		
		public Long getRegistryId() {
			return registryId;
		}

		// Devuelve el ID del usuario asociado al registro
		public Long getUserId() {
			return userId;
		}
		
		public ContentType getType() {
			return type;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public boolean isFav() {
			return fav;
		}

		// Modifica el estado de favorito
		public void setFav(boolean fav) {
			this.fav = fav;
		}

		// Devuelve la fecha de inicio
		public LocalDateTime getStartDate() {
			return startDate;
		}

		// Devuelve la URL de referencia
		public String getUrlRef() {
			return urlRef;
		}

		// Modifica la URL de referencia
		public void setUrlRef(String urlRef) {
			this.urlRef = urlRef;
		}

		public String getStatus() { 
			return status.toString(); 
		}
		
		public void setStatus(Status status) { 
			this.status = status; 
		}

		public float getRating() {	
			return rating.getRating();	
		}

		public void setRating(Rating rating) {	
			this.rating = rating;	
		}

		// Sección reservada para lógica adicional del registro
}