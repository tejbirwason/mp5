package mp5;

public class ComicBook {
	private final String comicBookTitle;
	
	public ComicBook(String comicBookTitle) {
		this.comicBookTitle = comicBookTitle;
	}

	public String getComicBookTitle() {
		return comicBookTitle;
	}

	@Overrides
	public boolean equals(Object other) {
		if (other instanceof ComicBook){
			ComicBook newcomicbook = (ComicBook) other;
			//check if the comicbook is the same by checking their titles.
			if ( this.getComicBookTitle().equals(newcomicbook.getComicBookTitle()) ){
				return true;
			}
		}
		return false; 
	}
	
}
