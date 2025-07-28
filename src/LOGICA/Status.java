package LOGICA;

public enum Status {
	
	NO_VISTO("NO_VISTO"),
	VIENDO("VIENDO"), 
	COMPLETADO("COMPLETADO"), 
	PENDIENTE("PENDIENTE"), 
	ABANDONADO("ABANDONADO"), 
	PLANIFICADO("PLANIFICADO"), 
	REVISTO("REVISTO");

	private Status(String status) {
		
		this.status = status;
		
	}
	
	String status;

	@Override
	public String toString() {
		return status;
	}
	
}