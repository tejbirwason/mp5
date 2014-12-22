package mp5;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


public class MarvelGraphTest {


	/**
	 * Test adding a vertex (marvel character) to the MarvelGraph
	 * @throws IOException
	 */
	@Test
	public void testAddingVertex() throws IOException {
		System.out.println("~ADDING VERTEX TEST~");
		
		MarvelGraph marvelGraph = new MarvelGraph();
		
		String testVertex = "Spider-Man";
		marvelGraph.addVertex(testVertex);
		
		marvelGraph.printVertices();
		
		assert( testVertex.equals(marvelGraph.getVertices().get(0)) );
	}
	
	/**
	 * Test adding an undirected edge between two vertices (marvel characters)
	 * @throws IOException
	 */
	@Test
	public void testAddingEdge() throws IOException {
		System.out.println("~ADDING EDGE TEST~");
		
		MarvelGraph marvelGraph = new MarvelGraph();
		String vertex1 = "Spider-Man";
		String vertex2 = "Bane";
		String comicBook = "Fictional";
		marvelGraph.addVertex(vertex1);
		marvelGraph.addVertex(vertex2);
		
		marvelGraph.addEdge(vertex1,vertex2,comicBook);
		marvelGraph.printEdges();
		
		assertEquals( marvelGraph.getEdges().get(0).getSh1() , vertex1 );
		assertEquals( marvelGraph.getEdges().get(0).getSh2() , vertex2 );
		assertEquals( marvelGraph.getEdges().get(0).getComicBook() , comicBook );
	}

	
	/**
	 * Test for finding the correct non-trivial shortest path (trace route) between two characters
	 * @throws IOException
	 */
	@Test
	public void testShortestPath() throws IOException {
		System.out.println("~SHORTEST PATH TRACE TEST~");
		
		/**
		 * Shortest path length between characters SH1 and SH4
		 * should route from SH1 ---A---> SH2 ---D---> SH4
		 *
		 * SH1 -------A----- SH2
  		 *    \              /  \
  		 *     \            /    \
  		 *   	B         C       D
 		 *  	 \       /         \
 		 *        \     /           \
 		 *  	    SH3              SH4
		 */
		MarvelGraph marvelGraph = new MarvelGraph();
		String vertex1  = "SH1";
		String vertex2  = "SH2";
		String vertex3  = "SH3";
		String vertex4  = "SH4";
		
		marvelGraph.addVertex(vertex1);
		marvelGraph.addVertex(vertex2);
		marvelGraph.addVertex(vertex3);
		marvelGraph.addVertex(vertex4);

		
		marvelGraph.addEdge(vertex1,vertex2,"A");
		marvelGraph.addEdge(vertex1,vertex3,"B");
		marvelGraph.addEdge(vertex2,vertex3,"C");
		marvelGraph.addEdge(vertex2,vertex4,"D");
		
		marvelGraph.printEdges();
		List<String> expected = new ArrayList<String>();
		// in order from source to target
		expected.add("A");
		expected.add("D");
		
		List<String> result = marvelGraph.getShortestPath(vertex1,vertex4);
		assertEquals(expected,result);
		
//		try {
//			
//		} catch (NoSuchMovieException | NoPathException e) {
//			e.printStackTrace();
//		}
	}
//	
	/**
	 * This test constructs the MarvelGraph from the given data set 
	 * and checks the number of vertices added to the graph
	 * 
	 * NOTE: This can be used to further test the MarvelGraph ADT as done 
	 * with the tests above
	 * 
	 * APPROXIMATE GRAPH BUILD TIME = 70 seconds
	 * 
	 * @throws IOException
	 */
	@Test
	public void testGraphConstructionOnOriginalData() throws IOException {
		MarvelIterator superHeroIterator = new MarvelIterator("labeled_edges.tsv");
		
		Map<String,List<String>> data = new HashMap<String,List<String>>();
		while ( superHeroIterator.hasNext() ) {
			MarvelEntry nextEntry = superHeroIterator.getNext();
			if(!data.containsKey(nextEntry.getSuperHeroName())){
				data.put(nextEntry.getSuperHeroName(),new ArrayList<String>());
			}
			data.get(nextEntry.getSuperHeroName()).add(nextEntry.getComicBook());
		}
		
		MarvelGraph graph = new MarvelGraph();
		for (String key : data.keySet()) {
	        graph.addVertex(key);
	    }
		for (String key : data.keySet()) {
			for(String comicBook: data.get(key)){
				for (String sh : data.keySet()) {
					if(!sh.equals(key)){
						for(String comicBook2: data.get(sh)){
							if(comicBook.equals(comicBook2)){
								graph.addEdge(sh,key,comicBook);
							}
						}
					}
				}
			}
	    }

		assertEquals(graph.getNumberOfVertices(),1682);	
	}
}
