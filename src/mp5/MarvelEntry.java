package mp5;

/**
 * Represents each line entry in the input file in a tabulated form
 * 
 * @author tejbirwason
 *
 */
public class MarvelEntry {
	private final String name;
	private final String comicBook;
	
	public MarvelEntry(String name, String comicBook) {
		super();
		this.name = name;
		this.comicBook = comicBook;
	}

	public String getName() {
		return name;
	}
	public String getComicBook() {
		return comicBook;
	}
}
