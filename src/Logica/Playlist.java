package Logica;

public class Playlist extends MediaContent{

	public Playlist() {
		super();
	}

	@Override
	public MediaContent addMediaContent(int numMediaContent) {
		
		return null;//reutilizar el constructor de usermediaregistry para poder elegir correctamente el tipo de mediacontent a agregar (a exepcion de playlist)
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
	
	//crear un metodo que permita cambiar el orden de los media content en la playlist, haciendo una shallow copy, y mediante el indice hacer el cambio de orden

}
