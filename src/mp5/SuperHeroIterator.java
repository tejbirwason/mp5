package mp5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperHeroIterator {

	private boolean next;
	private BufferedReader inputReader;
	private String nextRow;

	/**
	 * Create a MovieIterator given a filename.
	 * 
	 * @param fileName
	 *            the name of the file to open.
	 * @throws IOException
	 *             if there was a problem reading the file.
	 */
	public SuperHeroIterator(String fileName) throws IOException {

		// open the file
		this.inputReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName)));

		// read the first line and set the state of the iterator
		if ((nextRow = inputReader.readLine()) != null) {
			next = true;
		} else {
			next = false;
		}
	}

	/**
	 * Check if there is more data that the iterator can process.
	 * 
	 * @return true if there is more data to process otherwise return false.
	 */
	public boolean hasNext() {
		return next;
	}

	/**
	 * Return the next movie from the iterator.
	 * 
	 * @return the next movie in the list. Requires that hasNext() is true
	 *         otherwise null is returned.
	 */
	public SuperHero getNext() throws IOException {

		if (!next) {
			// we are the end of the stream so return null.
			// ideally the client should have checked hasNext() and this should
			// not be necessary
			return null;
		} else {
			
			//try to fix this
			nextRow.replaceAll("\"", " ");
			// split the string at the tabs to create columns
			String[] columns = nextRow.split("\t");
			for (String s: columns) {
				s.trim();
			}
			
			// the zeroth column represents the superhero name
			
			String[] superHeroNameAndID = columns[0].split("/");

			// grab the comicbook
			String comicBook = columns[1];
			ComicBook comicbook = new ComicBook(comicBook);
			
			// advance the iterator state wrt the input stream
			if ((nextRow = inputReader.readLine()) != null) {
				next = true;
			} else {
				next = false;
			}
			
			//if they have two names
			if ( superHeroNameAndID.length == 2 ){
				SuperHero nextSuperHero = new SuperHero(superHeroNameAndID[0],
						superHeroNameAndID[1] );
				nextSuperHero.addAppearance(comicbook);
				return nextSuperHero;
			} else {
				//if the hero has one name
				SuperHero nextSuperHero = new SuperHero(superHeroNameAndID[0],
						"" );
				nextSuperHero.addAppearance(comicbook);
				return nextSuperHero;
			
			}
			
			
		}
	}
}
