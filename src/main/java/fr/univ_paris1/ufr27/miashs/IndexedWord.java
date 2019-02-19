package fr.univ_paris1.ufr27.miashs;

/**
 * This class is a wrapper around a word and the line containing it.
 * @author nherbaut
 *
 */
public class IndexedWord {

	private final String word;
	private final int line;

	public IndexedWord(String word, int line) {
		this.word = word;
		this.line = line;
	}

	public String getWord() {
		return word;
	}

	public int getLine() {
		return line;
	}

	public String toString() {
		return this.word + " (" + this.line + ")";
	}

}
