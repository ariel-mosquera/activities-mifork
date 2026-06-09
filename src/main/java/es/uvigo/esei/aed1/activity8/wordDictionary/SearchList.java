package es.uvigo.esei.aed1.activity8.wordDictionary;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;

public class SearchList {

    private static boolean binarySearchList(List<String> listD, String word) {
        int start = 0;
        int end = listD.size() - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (listD.get(middle).compareTo(word) > 0)
                end = middle - 1;
            else if (listD.get(middle).compareTo(word) < 0)
                start = middle + 1;
            else
                return true;
        }

        return false;
    }

    private static List<String> binaryDictionarySearch(List<WordDictionary> dictionary, String word) {
        char targetLetter = word.charAt(0);
        int start = 0;
        int end = dictionary.size() - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (dictionary.get(middle).getLetter() > targetLetter)
                end = middle - 1;
            else if (dictionary.get(middle).getLetter() < targetLetter)
                start = middle + 1;
            else
                return dictionary.get(middle).getWordsList();
        }

        return null;
    }

    // Exercise 8
    public static boolean dictionarySearch(List<WordDictionary> dictionary, String word) {
        if (word == null || word.isBlank())
            return false;

        List<String> wordsList = binaryDictionarySearch(dictionary, word);

        if (wordsList == null)
            return false;

        return binarySearchList(wordsList, word);
    }
}
