package LOGICA;

public enum Rating {
	
	SIN_CALIFICACION(null, "SIN_CALIFICACION"), HORRIBLE(0 , "HORRIBLE"), MALO(1, "MALO"), PESIMO(2, "PESIMO"), REGULAR(3, "REGULAR"), BUENO(4, "BUENO"), SUBLIME(5 , "SUBLIME");
		
	private Rating (String nul, String comboValue){
		this.comboValue = comboValue;
	}
	
	private Rating (int rating, String comboValue) {
		this.rating = rating;
		this.comboValue = comboValue;
	}

	float rating;
	public final String comboValue;

	public float getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
		
	}
	
	@Override
	public String toString() {	
		return comboValue;
	}
	
	public float calcRating(Long id) {
		
		//se necesita una funcion filter que extraiga los videos del mediacontent respectivo desde la base de datos
		
		MediaContent cont;
		
		int numm = 0;
		int num = 0;
		
		for(int i = 0; i < num; i++) {
		
			if(true) {		// <- cont.isContainer() = false
			
				for(int j = 0; j < numm; j++) {
					rating =+ 1;
				}
			
			}
			
			rating = rating/(numm + num);
			
		}
		
		return rating;
		
	}
	
}
