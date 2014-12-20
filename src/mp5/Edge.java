package mp5;

public class Edge {
	private final SuperHero Hero1, Hero2;
	private final ComicBook comicBook;
	/**
	 * Construct an edge with given parameters
	 * @param Hero1
	 * @param Hero2
	 * @param comicBook
	 */
	public Edge(SuperHero hero1, SuperHero hero2, ComicBook comicBook) {
		this.Hero1 = hero1;
		this.Hero2 = hero2;
		this.comicBook = comicBook;
	}

	/**
	 * Determines the neighbouring hero of a supplied hero, 
	 * based on the 2 nodes connected by this edge.
	 * 
	 * @param hero	One of the two heros that this edge joins.
	 * @return 		The other neighbouring hero.
	 *
	 */
	public SuperHero getNeighbourMovie(SuperHero hero) {
		if (this.Hero1.hashCode() == hero.hashCode()) {
			return this.Hero2;
		} else {
			return this.Hero1;
		}
	}
	
	public SuperHero getHero1() {
		return Hero1;
	}

	public SuperHero getHero2() {
		return Hero2;
	}

	public ComicBook getComicBook() {
		return comicBook;
	}

	@Override
	public int hashCode() {
		int result = Hero1.hashCode() + Hero2.hashCode() + comicBook.hashCode();
		return result;
	}

	
}
