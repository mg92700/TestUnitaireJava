package fr.univ_paris1.ufr27.miashs;

public abstract class WordIndexor {

	/**
	 * Add this word to the indexor
	 * 
	 * @param word to be indexed
	 * @param line a line where we found the word
	 */
	public abstract void addword(String word, int line);

	/**
	 * This allows accessing the line where a specific word is written
	 * 
	 * @param word the work for which we look for the lines
	 * @return an array containing the lines, in the natural order
	 */
	public abstract Integer[] getLinesForWord(String word);

}