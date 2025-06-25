
public class Serie extends MediaContent {
	
	public Serie() {
		super();
	}

	@Override
	public MediaContent addMediaContent(int numMediaContent) {
		
		mediaContent.add(new Temporada());
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
