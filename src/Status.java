
public enum Status {
	
	VIENDO("VIENDO"), 
	COMPLETADO("COMPLETADO"), 
	PENDIENTE("PENDIENTE"), 
	ABANDONADO("ABANDONADO"), 
	PLANIFICADO("PLANIFICADO"), 
	REVISTO("REVISTO"), 
	NO_VISTO("NO_VISTO");

	private Status(String status) {
		
		this.status = status;
		
	}
	
	String status;

	@Override
	
	public String toString() {
		
		return status;
		
	}
	
}