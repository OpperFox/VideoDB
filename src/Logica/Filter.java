package Logica;

import java.util.stream.*;
import java.util.ArrayList;

public class Filter {
	
	
	public static ArrayList<UserMediaRegistry> filterMediaRegistry(ArrayList<UserMediaRegistry> sMediaRegistry, String text) {
		
		String ltext = text.toLowerCase();
		
	    return sMediaRegistry.stream()
	        .filter(t -> t.getName().toLowerCase().contains(ltext))
	        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static ArrayList<UserMediaRegistry> filterMediaRegistry(ArrayList<UserMediaRegistry> sMediaRegistry, boolean bool) {
	    return sMediaRegistry.stream()
	        .filter(t -> t.isFav() == bool)
	        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static ArrayList<UserMediaRegistry> filterMediaRegistry(ArrayList<UserMediaRegistry> sMediaRegistry, Long id) {
	    return sMediaRegistry.stream()
	        .filter(t -> t.getRegistryId() == id)
	        .collect(Collectors.toCollection(ArrayList::new));
	}

	public static ArrayList<UserMediaRegistry> filterMediaRegistry(ArrayList<UserMediaRegistry> sMediaRegistry, ContentType type) {
	    return sMediaRegistry.stream()
	        .filter(t -> t.getType() == type)
	        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static ArrayList<UserMediaRegistry> filterMediaRegistry(ArrayList<UserMediaRegistry> sMediaRegistry, Status status) {
	    return sMediaRegistry.stream()
	        .filter(t -> t.getStatus() == status.toString())
	        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static ArrayList<UserMediaRegistry> filterMediaRegistry(ArrayList<UserMediaRegistry> sMediaRegistry, Rating rating) {
	    return sMediaRegistry.stream()
	        .filter(t -> t.getRating() == rating.getRating())
	        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public static ArrayList<MediaContent> filterMediaContent(ArrayList<MediaContent> sMediaContent, String text) {
		
		String ltext = text.toLowerCase();
		
		return sMediaContent.stream()
		        .filter(t -> t.getName().toLowerCase().contains(ltext))
		        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static ArrayList<MediaContent> filterMediaContent(ArrayList<MediaContent> sMediaContent, Long id) {
		return sMediaContent.stream()
		        .filter(t -> t.getIdG() == id)
		        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public static ArrayList<Video> filterVideo(ArrayList<Video> sVideo, Long id) {
		return sVideo.stream()
		        .filter(t -> t.getId() == id)
		        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static ArrayList<Video> filterVideo(ArrayList<Video> sVideo, String name) {
		
		String lname = name.toLowerCase();
		
		return sVideo.stream()
		        .filter(t -> t.getName().toLowerCase().contains(lname))
		        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static ArrayList<UserVideoInfo> filterVideoInfo(ArrayList<UserVideoInfo> sVideoInfo, Long id) {
		return sVideoInfo.stream()
		        .filter(t -> t.getId() == id)
		        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static ArrayList<UserVideoInfo> filterVideoInfo(ArrayList<UserVideoInfo> sVideoInfo, Status status) {
	    return sVideoInfo.stream()
	        .filter(t -> t.getStatus() == status.toString())
	        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static ArrayList<UserVideoInfo> filterVideoInfo(ArrayList<UserVideoInfo> sVideoInfo, Rating rating) {
	    return sVideoInfo.stream()
	        .filter(t -> t.getRating() == rating.getRating())
	        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static ArrayList<UserVideoHistory> filterVideoHistory() {
		
		return null;
	
	}
	
	public static ArrayList<VideoURL> filterVideoURL() {
		
		return null;
		
	}
	
}
