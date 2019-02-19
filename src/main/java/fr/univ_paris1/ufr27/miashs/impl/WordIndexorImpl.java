package fr.univ_paris1.ufr27.miashs.impl;


import java.util.ArrayList;
import java.util.List;

import fr.univ_paris1.ufr27.miashs.IndexedWord;
import fr.univ_paris1.ufr27.miashs.WordIndexor;

/**
 * this class aims at storing words and their
 * 
 * @author nherbaut
 *
 */
public class WordIndexorImpl extends WordIndexor {
	
	private IndexedWord indexedWord;
	private  String word;
	private int line;
	private static List<IndexedWord> lstIndexword = new ArrayList<IndexedWord>();
	 
	public static List<IndexedWord> getLstIndexword() {
		return lstIndexword;
	}

	@Override
	public void addword(String word, int line) {
		
		this.word=word;
		this.line=line;
		indexedWord = new IndexedWord(word, line);	
		lstIndexword.add(indexedWord);
		
	}

	@Override
	public Integer[] getLinesForWord(String word) {
		// TODO Auto-generated method stub
		List<Integer>  lstElementOld =  new ArrayList<Integer>();
		
		for(IndexedWord elementIndexedWord :lstIndexword)
		{
			 
			if(elementIndexedWord.getWord().equals(word))
			{
				lstElementOld.add(elementIndexedWord.getLine());
			}
			
		}
		List<Integer>  lstElementNew =  new ArrayList<Integer>();
		for(Integer entier: lstElementOld)
		{
			if(lstElementNew.contains(entier)==false) {
				
				lstElementNew.add(entier);
			}
			
		}
		Integer[] tabIngeter = new Integer[lstElementNew.size()];
		    int i = 0;
		    for (Integer e : lstElementNew)  
		        tabIngeter[i++] = e;
	    return tabIngeter;
		
		
	}

	public IndexedWord getIndexedWord() {
		return indexedWord;
	}

	public void setIndexedWord(IndexedWord indexedWord) {
		this.indexedWord = indexedWord;
	}



	
	
}
