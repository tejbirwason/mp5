package mp5;

public class MarvelEntry {
	private final String superHeroName;
	private final String secretIdentity;
	private final String comicBook;
	
	public MarvelEntry(String superHeroName, String secretIdentity, String comicBook) {
		super();
		this.superHeroName = superHeroName;
		this.secretIdentity = secretIdentity;
		this.comicBook = comicBook;
	}
	public MarvelEntry(String superHeroName, String comicBook) {
		super();
		this.superHeroName = superHeroName;
		this.secretIdentity = null;
		this.comicBook = comicBook;
	}
	public String getSuperHeroName() {
		return superHeroName;
	}
	public String getSecretIdentity() {
		return secretIdentity;
	}
	public String getComicBook() {
		return comicBook;
	}
}
