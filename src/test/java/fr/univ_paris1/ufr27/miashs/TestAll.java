package fr.univ_paris1.ufr27.miashs;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import fr.univ_paris1.ufr27.miashs.impl.WordIndexorImpl;
import fr.univ_paris1.ufr27.miashs.impl.WordParserImpl;

public class TestAll {

	
	@Test
	public void testingFile1() throws IOException {

		try (WordParser parser = new WordParserImpl(new File("src/main/resources/test1.txt"))) {
			WordIndexor indexor = new WordIndexorImpl();
			for (IndexedWord indexedWord : parser) {
				indexor.addword(indexedWord.getWord(), indexedWord.getLine());
			}
			assertArrayEquals(new Integer[] { 3 }, indexor.getLinesForWord("ce"));
			assertArrayEquals(new Integer[] { 1 }, indexor.getLinesForWord("chien"));
			assertArrayEquals(new Integer[] { 3 }, indexor.getLinesForWord("est"));
			assertArrayEquals(new Integer[] { 1, 2, 3 }, indexor.getLinesForWord("joli"));
			assertArrayEquals(new Integer[] { 2 }, indexor.getLinesForWord("os"));
			assertArrayEquals(new Integer[] { 1, 2, 3 }, indexor.getLinesForWord("petit"));
			assertArrayEquals(new Integer[] { 3 }, indexor.getLinesForWord("qui"));
			assertArrayEquals(new Integer[] { 2 }, indexor.getLinesForWord("ronge"));

			assertArrayEquals(new Integer[] { 1, 3 }, indexor.getLinesForWord("tout"));
			assertArrayEquals(new Integer[] { 1, 2 }, indexor.getLinesForWord("un"));
		}

	}

	
	@Test
	public void testingFile3BIG() throws IOException {

		try (WordParser parser = new WordParserImpl(new File("src/main/resources/test3.txt"))) {
			WordIndexor indexor = new WordIndexorImpl();
			for (IndexedWord indexedWord : parser) {
				indexor.addword(indexedWord.getWord(), indexedWord.getLine());
			}
			assertArrayEquals(new Integer[] { 46391, 46563 }, indexor.getLinesForWord("zeus"));
		}

	}
	

	@Test
	public void testingWithAString() throws IOException {

		String FILE_DATA = "Un tout petit chien, joli \n  ronge  un joli petit os ; \nTout ce qui est petit est joli.";
		try (WordParser parser = new WordParserImpl(FILE_DATA)) {
			WordIndexor indexor = new WordIndexorImpl();
			for (IndexedWord indexedWord : parser) {
				indexor.addword(indexedWord.getWord(), indexedWord.getLine());
			}
			assertArrayEquals(new Integer[] { 3 }, indexor.getLinesForWord("ce"));
			assertArrayEquals(new Integer[] { 1 }, indexor.getLinesForWord("chien"));
			assertArrayEquals(new Integer[] { 3 }, indexor.getLinesForWord("est"));
			assertArrayEquals(new Integer[] { 1, 2, 3 }, indexor.getLinesForWord("joli"));
			assertArrayEquals(new Integer[] { 2 }, indexor.getLinesForWord("os"));
			assertArrayEquals(new Integer[] { 1, 2, 3 }, indexor.getLinesForWord("petit"));
			assertArrayEquals(new Integer[] { 3 }, indexor.getLinesForWord("qui"));
			assertArrayEquals(new Integer[] { 2 }, indexor.getLinesForWord("ronge"));

			assertArrayEquals(new Integer[] { 1, 3 }, indexor.getLinesForWord("tout"));
			assertArrayEquals(new Integer[] { 1, 2 }, indexor.getLinesForWord("un"));
		}

	}
	
	//ajout d'un nouveau test
	@Test
	public void testingWithPonctuation() throws IOException {

		String FILE_DATA = "hamza a loser son partiel du-coup, \n il a tous donner sur le tp4.";
		try (WordParser parser = new WordParserImpl(FILE_DATA)) {
			WordIndexor indexor = new WordIndexorImpl();
			for (IndexedWord indexedWord : parser) {
				indexor.addword(indexedWord.getWord(), indexedWord.getLine());
			}
			
			assertArrayEquals(new Integer[] { 1,2 }, indexor.getLinesForWord("a"));
			assertArrayEquals(new Integer[] { 2 }, indexor.getLinesForWord("tp4"));
			assertArrayEquals(new Integer[] { 1 }, indexor.getLinesForWord("loser"));
			}

	}
	

}
