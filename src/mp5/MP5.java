package mp5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MP5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for(int i=0; i < args.length; i++)
			System.out.println( args[i] );
		
		SuperHeroIterator superHeroIterator = new SuperHeroIterator("labeled_edges.tsv");
		
		
		int i=0;
		
		Map<String,List<String>> data = new HashMap<String,List<String>>();
		
		while ( superHeroIterator.hasNext()) {
			MarvelEntry nextEntry = superHeroIterator.getNext();
//			System.out.println(nextEntry.getSuperHeroName());
//			System.out.println(nextEntry.getSecretIdentity());
//			System.out.println(nextEntry.getComicBook());
			
			if(!data.containsKey(nextEntry.getSuperHeroName())){
				data.put(nextEntry.getSuperHeroName(),new ArrayList<String>());
			}
			data.get(nextEntry.getSuperHeroName()).add(nextEntry.getComicBook());
	
			i++;
		}
		
		MarvelGraph graph = new MarvelGraph();
		
		for (String key : data.keySet()) {
	        System.out.println(key + " " + data.get(key));
	        //graph.addVertex(key);
	    }
		for (String key : data.keySet()) {
			for(String comicBook: data.get(key)){
				for (String sh : data.keySet()) {
					if(!sh.equals(key)){
						for(String comicBook2: data.get(sh)){
							if(comicBook.equals(comicBook2)){
								graph.addEdge(sh,key);
							}
						}
					}
				}
			}
	    }
		
		for (String key : data.keySet()) {
	        System.out.println(key + " " + data.get(key));
	        graph.addVertex(key);
	    }
		
		
		

		
		
	}


}
