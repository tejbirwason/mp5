package mp5;

/**
 * An undirected and unweighted edge for the MarvelGraph
 * with two vertex (characters) and associated comicBook linking 
 * both the vertices
 * 
 * @author tejbirwason
 *
 */
public class Edge {
	private final String sh1;
	private final String sh2;
	private final String comicBook;
	
	public Edge(String sh1, String sh2, String comicBook) {
		super();
		this.sh1 = sh1;
		this.sh2 = sh2;
		this.comicBook = comicBook;
	}
	
	/**
	 * Determines the neighbouring character of a supplied character, based on the 2 nodes connected by this edge.
	 * 
	 * @param superHero One of the characters that this edge joins.
	 * @return The neighbouring character.
	 *
	 */
	public String getNeighbourCharacter(String superHero) {
		if (sh1.equals(superHero)) {
			return this.sh2;
		} else {
			return this.sh1;
		}
	}
	
	/**
	 * To handle edges being undirected
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Edge){
			if( this.comicBook.equals(((Edge) obj).comicBook))
			{
				if((this.sh1.equals(((Edge) obj).sh1) && this.sh2.equals(((Edge) obj).sh2)) 
				|| (this.sh1.equals(((Edge) obj).sh2) && this.sh2.equals(((Edge) obj).sh1))){
					return true;
				}
			}
		}
		return false;
	}
	
	public String getSh1() {
		return sh1;
	}

	public String getSh2() {
		return sh2;
	}

	public String getComicBook() {
		return comicBook;
	}

	@Override
	public int hashCode() {
		int result = sh1.hashCode() + sh2.hashCode() + comicBook.hashCode();
		return result;
	}
}



