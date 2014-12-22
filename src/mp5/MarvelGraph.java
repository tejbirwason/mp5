package mp5;

import java.util.List;

// TODO: Implement this class that represents an undirected graph with movies as vertices.
// The edges are weighted.
// This graph should be immutable except for the addition of vertices and edges. 
// It should not be possible to change a vertex after it has been added to the graph.

// You should indicate what the representation invariants and the abstraction function are for the representation you choose.

public class MarvelGraph {

	/**
	 * Add a new movie to the graph. If the movie already exists in the graph
	 * then this method will return false. Otherwise this method will add the
	 * movie to the graph and return true.
	 * 
	 * @param movie
	 *            the movie to add to the graph. Requires that movie != null.
	 * @return true if the movie was successfully added and false otherwise.
	 * @modifies this by adding the movie to the graph if the movie did not
	 *           exist in the graph.
	 */
	public boolean addVertex(String superHeroName) {
		// TODO: Implement this method
		
		System.out.println("Adding Vertex = "+superHeroName);
		return false;
	}

	/**
	 * Add a new edge to the graph. If the edge already exists in the graph then
	 * this method will return false. Otherwise this method will add the edge to
	 * the graph and return true.
	 * 
	 * @param movie1
	 *            one end of the edge being added. Requires that m1 != null.
	 * @param movie2
	 *            the other end of the edge being added. Requires that m2 !=
	 *            null. Also require that m1 is not equal to m2 because
	 *            self-loops are not meaningful in this graph.
	 * @param edgeWeight
	 *            the weight of the edge being added. Requires that edgeWeight >
	 *            0.
	 * @return true if the edge was successfully added and false otherwise.
	 * @modifies this by adding the edge to the graph if the edge did not exist
	 *           in the graph.
	 */
	public boolean addEdge(String sh1, String sh2) {
		// TODO: Implement this method
		
		System.out.println(sh1 + " <----> " + sh2);
		return false;
	}


	/**
	 * Return the length of the shortest path between two movies in the graph.
	 * Throws an exception if the movie ids do not represent valid vertices in
	 * the graph.
	 * 
	 * @param moviedId1
	 *            the id of the movie at one end of the path.
	 * @param moviedId2
	 *            the id of the movie at the other end of the path.
	 * @throws NoSuchMovieException
	 *             if one or both arguments are not vertices in the graph.
	 * @throws NoPathException
	 *             if there is no path between the two vertices in the graph.
	 * 
	 * @return the length of the shortest path between the two movies
	 *         represented by their movie ids.
	 */
	public List<String> getShortestPathLength(String sh1, String sh2){
			//throws NoSuchHeroException, NoPathException {
		// TODO: Implement this method
		return null;
	}


	// Implement the next two methods for completeness of the MovieGraph ADT

	@Override
	public boolean equals(Object other) {
		// TODO: Implement this
		return false;
	}

	@Override
	public int hashCode() {
		// TODO: Implement a reasonable hash code method
		return 42;
	}

}