package mp5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

import mp4.NoSuchMovieException;




// TODO: Implement this class that represents an undirected graph with marvel characters as vertices.
// This graph should be immutable except for the addition of vertices and edges. 
// It should not be possible to change a vertex after it has been added to the graph.

//Rep invariant:
//	vertices, edges != null
//	for all x, y such that y is a member of edges.get(x),
//  	x and y are both members of vertices
//Abstraction function:
//	represents an undirected graph whose vertices are the set of vertices
//  and whose edges are the set (x,y) such that y is a member of edges.get(x)
//Thread safety argument:
//- vertices and edges are Strings, so those variables are immutable and threadsafe
//- vertices and edges point to threadsafe set and map data types

public class MarvelGraph {

	private final List<String> vertices = new ArrayList<String>();
	private final List<Edge> edges = new ArrayList<Edge>();
	
	private Map<String,ArrayList<Edge>> characterEdgesMap =new HashMap<String,ArrayList<Edge>>();
	
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
		
		vertices.add(superHeroName);
		characterEdgesMap.put(superHeroName, new ArrayList<Edge>());
		
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
	public boolean addEdge(String sh1, String sh2, String comicBook) {
		Edge e = new Edge(sh1,sh2,comicBook);
		
		for(Edge edge : edges){
			if(edge.equals(e)){
				return false;
			}
		}
		
//		System.out.println(sh1 + " <----"+comicBook+"----> " + sh2);
		
		edges.add(e);
		characterEdgesMap.get(sh1).add(e);
		characterEdgesMap.get(sh2).add(e);
		
		return true;
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
	public List<String> getShortestPath(String sh1, String sh2)
			throws NoSuchCharacterException, NoPathException {
		
		 if (!vertices.contains(sh1) | !vertices.contains(sh2)){
			 throw new NoSuchCharacterException();
		 }
		Queue<String> q = new LinkedList<String>();
		Map<String,List<String>> path = new HashMap<String,List<String>>();
		q.add(sh1);
		path.put(sh1, new ArrayList<String>());
		while(!q.isEmpty())		
		{
            String parent = q.remove();   
            if(parent.equals(sh2))
            {
            	System.out.println("Found a path!"+ path.get(parent));
            	return new ArrayList<String>(path.get(parent));
            }
			//For every child connected to the parent								 			           
            for(Edge e : characterEdgesMap.get(parent)){
            	String child = e.getNeighbourCharacter(parent);
            	if(!path.containsKey(child)){
            		List<String> temp = new ArrayList<String>(path.get(parent));
            		temp.add(e.getComicBook());
            		path.put(child,temp);
            		q.add(child);
            	}
            }
		}
		System.out.println("Not Found!");
		return null;
	}
	
	
	/**
	 * Return the edge list for testing purposes
	 * @return vertices 
	 */
	public List<Edge> getEdges() {
		return new ArrayList<Edge>(edges);
	}
	
	/**
	 * Return the vertex list for testing purposes
	 * @return vertices 
	 */
	public List<String> getVertices() {
		return new ArrayList<String>(vertices);
	}
	
	/**
	 * Prints the graph edges for testing purposes
	 * @return	void
	 */
	public void printEdges() {
			System.out.println("**GRAPH EDGES**");
			for ( Edge edge: edges ){
				System.out.println(edge.getSh1() + " <---"+edge.getComicBook()+"" +
						"---> " + edge.getSh2());
			}
			System.out.println("**END**\n");
	}

	/**
	 * Prints the graph vertices for testing purposes
	 * @return	void
	 */
	public void printVertices() {
			System.out.println("**GRAPH VERTICES**");
			for ( String superhero: vertices ){
				System.out.println(superhero);
			}
			System.out.println("**END**\n");
		
	}	
	
	/**
	 * Returns the total number of vertices in the graph
	 * @return	size
	 */
	public int getNumberOfVertices(){
		System.out.println("Vertices = "+vertices.size());
		return vertices.size();
	}
}