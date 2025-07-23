package Logica;
import java.time.LocalDateTime;
import java.util.ArrayList;
//importacion modulo LocalDateTime para manejo de las fechas de cada registro de visualizacion del video

public class UserVideoHistory {

	//Atributos de la clase
	private Long videoId;
	private Long userId;
	private ArrayList <LocalDateTime> watchHistory;

	
	//Constructor vacio
	public UserVideoHistory () {
		watchHistory.add(null);
		
		//el primer valor del array siempre sera la fecha en la que se creo el MediaContent, si el video se creo junto con este 
		
	}

	
	//Setters y Getters
	
	public ArrayList getWatchHistory() {
		return watchHistory;
	}
	
	public void addWatchHistory() {
		//Usara la fecha actual y la añadira al array, debera cambiar el estado del MediaContent a VIENDO y el video a REVISTO.
		//Un MediaContent solo sera revisto cuando todos sus videos hayan sido revistos minimo 1 vez.
	}

	public Long getVideoId() {
		return videoId;
	}

	public Long getUserId() {
		return userId;
	}
	
}