package LOGICA;
import java.util.ArrayList;
// Importa ArrayList para poder manejar una lista dinámica de registros multimedia asociados al usuario

public class User {

	// Atributos de instancia
	private Long userId; // ID único de este usuario
	private ArrayList<UserMediaRegistry> userMediaRegistry; // Lista de registros

	// Constructor que recibe el nombre del usuario
	public User(Long id, String name, String password) {
		//userId = consulta BD
		userId = id;           // Asigna ID único al usuario incrementando el contador global
		
		//update BD de id,name,password
		
		this.userMediaRegistry = new ArrayList<UserMediaRegistry>();
		
	}

	// Getters y Setters

	// Devuelve el ID único del usuario
	public Long get_userId() {
		return userId;
	}

	// Devuelve la lista de registros multimedia del usuario
	public ArrayList<UserMediaRegistry> get_userMedia() {
		return userMediaRegistry;
	}

	// Devuelve el contador global de IDs de usuarios
	public Long get_id() {
		return userId;
	}

	// Lógica

	// Agrega un nuevo registro multimedia vacío al usuario
	public void new_registry() {
		userMediaRegistry.add(new UserMediaRegistry(userId, null)); 
		//Se crea un nuevo registro con el userId actual, se debe implementar una solucion para que el usuario elija un tipo de MediaContent indicado en el Enum... 
		//ContentType
	}
}
