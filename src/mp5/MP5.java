package mp5;

import java.io.IOException;

public class MP5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for(int i=0; i < args.length; i++)
		System.out.println( args[i] );
		
		SuperHeroIterator iterator = new SuperHeroIterator("labeled_edges.tsv");
		SuperHero newhero = iterator.getNext();
		System.out.println(newhero.getSuperHeroName());
		System.out.println(newhero.getSecretIdentity());
		
	}

}
