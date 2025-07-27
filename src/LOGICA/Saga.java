package LOGICA;

public class Saga extends MediaContent{
	
	public Saga(Long id_g, Long registryId, int loc) {
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
		
		this.name = newName;
		
		return null;
	}


	@Override
	public MediaContent addMediaContent(Long id, Long registryId, int numMediaContent) {
		// TODO Auto-generated method stub
		return null;
	}

}
