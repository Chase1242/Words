/* 
 * Creator: Chase Conaway
 * Started: September 1st, 2020
 * Last Edited: September 21st
 * This program takes a set of letters, then exhaustively searches for all possible words
 * in the provided dictionary.
 */

import java.util.*;
import java.io.*;

public class WordFinder {
	private static HashSet<String> words;
	
	public static void main(String[]args) throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
		Scanner input = new Scanner(new File("dictionary.txt"));
		
		words = new HashSet<String>();
		while (input.hasNextLine()) {
			String currWord = input.nextLine();
			if (!words.contains(currWord)) {
				words.add(currWord);
			}
		}
		System.out.println("How many letters?");
		
		String[] letters = new String[console.nextInt()];
		System.out.println("What letter?");
		for (int i = 0; i < letters.length; i++) {
			letters[i] = console.next();
			System.out.println("Next letter");
		}
		System.out.println(Arrays.toString(letters));
		
		TreeSet<String> wordsToP = new TreeSet<String>();
		findWords("", letters, wordsToP, letters.length);
		System.out.println(wordsToP);
	}
	
	public static void findWords(String word, String[] letters, Set<String> wordsToP,
								 int numLeft) {
		
		if (!wordsToP.contains(word) && words.contains(word)) {
			wordsToP.add(word);
			
		} else if (numLeft > 0) {
			for (String letter : letters) {			
				findWords(word + letter, letters, wordsToP, numLeft - 1);
				
			}
			

		}
	}
}
