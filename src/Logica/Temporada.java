package Logica;

public class Temporada extends MediaContent{
	
	public Temporada(Long id, Long idAlfa, int loc) {
		super(id, idAlfa, loc);
		
		this.container = false;
		this.id_l = loc;
		
	}



	@Override
	public MediaContent removeMediaContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MediaContent getMediaContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MediaContent setMediaContentName(String newName) {
		
		this.name = newName;
		
		return null;
	}

	@Override
	public MediaContent addMediaContent(Long id, Long idAlfa, int numMediaContent) {
		// TODO Auto-generated method stub
		return null;
	}

}
