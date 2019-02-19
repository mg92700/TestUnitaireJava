package fr.univ_paris1.ufr27.miashs;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * This class is used to parses a file or a String to allows accessing all the
 * index words (i.e. the word and the line where we found it).
 * 
 * @author nherbaut
 *
 */
public abstract class WordParser implements Iterable<IndexedWord>, Iterator<IndexedWord>, Closeable {

	protected WordParser() {
	}

	public WordParser(File f) throws FileNotFoundException {
		InputStream inputstream = new FileInputStream(f);

	}

	public WordParser(String data) throws FileNotFoundException {
		InputStream inputstream = new FileInputStream(data);
	}

}