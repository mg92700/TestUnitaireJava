package fr.univ_paris1.ufr27.miashs.impl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import fr.univ_paris1.ufr27.miashs.IndexedWord;
import fr.univ_paris1.ufr27.miashs.WordParser;


public class WordParserImpl extends WordParser {

	
	private IndexedWord idx;
	
	private int count=0;
	private int countElement=1;
	
	//Initialisation du reader
	private Reader inputStreamReader;

	
	//Prend un chemin en paramettre 
	public WordParserImpl(File file) throws IOException {
		int countligne=0;
		 inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
	    try (LineNumberReader reader = new LineNumberReader(inputStreamReader)) 
	    {
	      String ligne;
	      while ((ligne = reader.readLine()) != null) {
	    	  countligne++;
	    	  String[] ary =ligne.split(" ");
	    	  for(String s : ary)
	    	  {
	    		  String chaineFinal=s.replaceAll("[^A-Za-z0-9]", "");
	    		  chaineFinal=chaineFinal.trim();
	    		  chaineFinal=chaineFinal.toLowerCase();
	    		  WordIndexorImpl wordIndexor = new WordIndexorImpl();
	    		  boolean sortir=false;
	    		  while(iterator().hasNext() && !sortir)
	    		  {
	    			  wordIndexor.addword(chaineFinal, countligne);
	    			 
	    			  idx=wordIndexor.getIndexedWord();
	    			  countElement++;
	    			  idx=iterator().next();
	    			  sortir=true;
	    			  
	    		  }
	    	  }
	      }
	      
	    }
		
	}
	
	//Prend un chaine en paramettre
	public WordParserImpl(String data) throws IOException {
		
		inputStreamReader = new StringReader(data);
		int countligne=0;
	    try (LineNumberReader reader = new LineNumberReader(inputStreamReader)) 
	    {
	      String ligne;
	      while ((ligne = reader.readLine()) != null) {
	    	  countligne++;
	    	  String[] ary =ligne.split(" ");
	    	  for(String s : ary)
	    	  {
	    		  String chaineFinal=s.replaceAll("[^A-Za-z0-9]", "");
	    		  chaineFinal=chaineFinal.trim();
	    		  chaineFinal=chaineFinal.toLowerCase();
	    		  WordIndexorImpl wordIndexor = new WordIndexorImpl();
	    		  boolean sortir=false;
	    		  while(iterator().hasNext() && !sortir)
	    		  {
	    			  wordIndexor.addword(chaineFinal, countligne);
	    			  idx=wordIndexor.getIndexedWord();
	    			  countElement++;
	    			  idx=iterator().next();
	    			  sortir=true;
	    		  }
	    	  }
	      }

		}  
	}

	//retourn Iterator<indexedword> courant
	@Override
	public Iterator<IndexedWord> iterator() {
		return this;
	}

	//Retourne vrai pour continuer
	@Override
	public boolean hasNext() {
		if(count<countElement)
		{
			return true;
		}
		return false;
	}

	//Ajout un element indexedword
	@Override
	public IndexedWord next() {
	if(count==countElement)
		throw new NoSuchElementException();
	count++;
	return idx;
	
	}

	//ferme le reader
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		idx=null;
		count=0;
		countElement=1;
		WordIndexorImpl.getLstIndexword().clear();
		inputStreamReader.close();	
	}


}
