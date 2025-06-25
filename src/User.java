import java.util.ArrayList;

public class User {

	//Atributos de clase 
	static private Long id;
	
	private Long userId;
	private String name = null;
	private ArrayList<UserMediaRegistry> userMediaRegistry;

	
	//Constructores
	
	public User (String name) {
		
		userId = id++;
		this.name = name;
		
	}
	
	//Setters y Getters
	public String get_name() {
		return name;
	}

	public void set_name(String name) {
		this.name = name;
	}

	public Long get_userId() {
		return userId;
	}

	public ArrayList<UserMediaRegistry> get_userMedia() {
		return userMediaRegistry;
	}

	public static Long get_id() {
		return id;
	}
	
	
	//Logica
	
	public void new_registry() {
		userMediaRegistry.add(new UserMediaRegistry(userId, null)); //posteriormente pedir que el usuario rellene el segundo parametro ContentType
	}

}