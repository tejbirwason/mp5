package mp5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarvelIterator {

	private boolean next;
	private BufferedReader inputReader;
	private String nextRow;

	/**
	 * Create a MarvelIterator given a filename.
	 * 
	 * @param fileName
	 *            the name of the file to open.
	 * @throws IOException
	 *            if there was a problem reading the file.
	 */
	public MarvelIterator(String fileName) throws IOException {

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
	 * Return the next line from the iterator.
	 * 
	 * @return the next line in the list. Requires that hasNext() is true
	 *         otherwise null is returned.
	 */
	public MarvelEntry getNext() throws IOException {

		if (!next) {
			// we are the end of the stream so return null.
			// ideally the client should have checked hasNext() and this should
			// not be necessary
			return null;
		} else {
			

			// split the string at the tabs to create columns
			String[] tabulatedEntry = nextRow.replaceAll("\"", "").split("\t");
			for (String s: tabulatedEntry) {
				s.trim();
			}

			// advance the iterator state wrt the input stream
			if ((nextRow = inputReader.readLine()) != null) {
				next = true;
			} else {
				next = false;
			}
			
			return new MarvelEntry(tabulatedEntry[0],tabulatedEntry[1]);
		}
	}
}
