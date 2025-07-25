package Logica;

public class Saga extends MediaContent{
	
	public Saga(Long id) {
		super(id);
		
		this.container = false;
		
	}

	@Override
	public MediaContent addMediaContent(int numMediaContent) {
		
		return null;
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

}
