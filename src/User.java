import java.util.ArrayList;

public class User {

	//Atributos de clase 
	static private int id;
	
	private int userId;
	private String name = null;
	private ArrayList<UserMediaRegistry> userMediaRegistry;

	
	//Constructores
	public User (int userId) {
		
		this.userId = userId;
		
	}
	
	public User (String name) {
		
		id++;
		this.name = name;
		
	}
	
	//Setters y Getters
	public String get_name() {
		return name;
	}

	public void set_name(String name) {
		this.name = name;
	}

	public int get_userId() {
		return userId;
	}

	public ArrayList<UserMediaRegistry> get_userMedia() {
		return userMediaRegistry;
	}

	public static int get_id() {
		return id;
	}
	
	
	//Logica
	
	public void new_registry() {
		userMediaRegistry.add(new UserMediaRegistry());
	}

}