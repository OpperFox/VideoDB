package Logica;
import java.util.ArrayList;
// Importa ArrayList para poder manejar una lista dinámica de registros multimedia asociados al usuario

public class User {

	// Atributos de clase
	static private Long id; // Contador estático para generar IDs únicos por usuario

	// Atributos de instancia
	private Long userId; // ID único de este usuario
	private String name = null; // Nombre del usuario
	private ArrayList<UserMediaRegistry> userMediaRegistry; // Lista de registros

	// Constructor que recibe el nombre del usuario
	public User(String name) {
		userId = id++;           // Asigna ID único al usuario incrementando el contador global
		this.name = name;        // Asigna el nombre al usuario
		
		this.userMediaRegistry = new ArrayList<UserMediaRegistry>();
		
	}

	// Getters y Setters

	// Devuelve el nombre del usuario
	public String get_name() {
		return name;
	}

	// Permite modificar el nombre del usuario
	public void set_name(String name) {
		this.name = name;
	}

	// Devuelve el ID único del usuario
	public Long get_userId() {
		return userId;
	}

	// Devuelve la lista de registros multimedia del usuario
	public ArrayList<UserMediaRegistry> get_userMedia() {
		return userMediaRegistry;
	}

	// Devuelve el contador global de IDs de usuarios
	public static Long get_id() {
		return id;
	}

	// Lógica

	// Agrega un nuevo registro multimedia vacío al usuario
	public void new_registry() {
		userMediaRegistry.add(new UserMediaRegistry(userId, null)); 
		//Se crea un nuevo registro con el userId actual, se debe implementar una solucion para que el usuario elija un tipo de MediaContent indicado en el Enum... 
		//ContentType
	}
}
