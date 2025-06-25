
public enum ContentType {
		
	TEMPORADA(new Temporada()), SERIE(new Serie()), PLAYLIST(new Playlist()), SAGA(new Saga());
	
	public final MediaContent type;
	
	private ContentType(MediaContent type) {
		this.type = type;
	}
	
	public MediaContent get_type() {
		return type;
	}

}
