import java.time.LocalDateTime;
import java.util.ArrayList;

// Importación del módulo LocalDateTime para manejo de fechas
// Importación de ArrayList para manejar listas de contenido multimedia

public class UserMediaRegistry {

	// Atributos de clase compartidos por todas las instancias
	private static Long id; // Contador estático para generar IDs únicos de registros

	// Atributos de instancia
	private Long registryId; // ID único del registro de contenido
	private Long userId;     // ID del usuario al que pertenece este registro

	private boolean fav;     // Marca si este contenido fue marcado como favorito
	private LocalDateTime startDate; // Fecha de inicio de visualización o registro
	
	private String urlRef;   // Referencia a una URL asociada al contenido (por ejemplo, imagen o enlace)
	private String name;     // Nombre del contenido registrado
	private ContentType type; // Tipo de contenido (Serie, Temporada, etc.)

	private ArrayList<MediaContent> mediaContent; // Lista que almacena el contenido multimedia asociado


	// Constructores

		// Constructor que recibe solo el userId y tipo de contenido, asigna nombre por defecto
		public UserMediaRegistry(Long userId, ContentType type) {
			this(userId, type, "NO_NAME");
		}

		// Constructor que recibe userId, tipo y nombre, y asigna valor falso a fav
		public UserMediaRegistry(Long userId, ContentType type, String name) {
			this(userId, type, name, false);
		}

		// Constructor que recibe userId, tipo, nombre y fav, asigna URL por defecto
		public UserMediaRegistry(Long userId, ContentType type, String name, boolean fav) {
			this(userId, type, name, fav, "NO_URL");
		}

		// Constructor principal que inicializa todos los atributos esenciales
		public UserMediaRegistry(Long userId, ContentType type, String name, boolean fav, String urlRef) {
			registryId = ++id; // Asigna un ID único incrementando el contador global
			this.userId = userId;
			this.name = name;
			this.fav = fav;
			this.urlRef = urlRef;
			this.type = type;

			// Inicializa la lista de contenidos
			mediaContent = new ArrayList<>();

			// Si el tipo no es nulo, se agrega su contenido base a la lista
			if (this.type != null) {
				mediaContent.add(this.type.get_type());
			}
		}

		// Métodos de acceso (getters y setters)

		// Devuelve si el contenido está marcado como favorito
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

		// Establece la fecha de inicio
		public void setStartDate(LocalDateTime startDate) {
			this.startDate = startDate;
		}

		// Devuelve la URL de referencia
		public String getUrlRef() {
			return urlRef;
		}

		// Modifica la URL de referencia
		public void setUrlRef(String urlRef) {
			this.urlRef = urlRef;
		}

		// Devuelve el ID único del registro
		public Long getRegistryId() {
			return registryId;
		}

		// Devuelve el ID del usuario asociado al registro
		public Long getUserId() {
			return userId;
		}

		// public String getStatus() { return status; }
		// public void setStatus(String status) { this.status = status; }

		// Sección reservada para lógica adicional del registro
}