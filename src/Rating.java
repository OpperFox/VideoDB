
public enum Rating {
	
	SIN_CALIFICACION(null), HORRIBLE(0), MALO(1), PESIMO(2), REGULAR(3), BUENO(4), SUBLIME(5);
		
	private Rating (String nul){
		
	}
	
	private Rating (int rating) {
		this.rating = rating;
	}

	float rating;

	public float getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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
