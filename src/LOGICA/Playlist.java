package LOGICA;

public class Playlist extends MediaContent{

	public Playlist(Long id_g, Long registryId, int loc) {
		super(id_g, registryId, loc);
		
		this.container = false;
		
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MediaContent addMediaContent(Long id, Long registryId, int numMediaContent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//crear un metodo que permita cambiar el orden de los media content en la playlist, haciendo una shallow copy, y mediante el indice hacer el cambio de orden

}
