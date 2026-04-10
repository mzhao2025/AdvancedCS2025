import java.util.ArrayList;
import java.util.AbstractList;

public class AnagramList extends AbstractList<Word> {
    private ArrayList<Word> wordList;
    
    public AnagramList() {
        this.wordList = new ArrayList<Word>();
    }

    public boolean add(Word word) {
        wordList.add(word);
        return true;
    }

    public boolean checkAnagram(Word word1, Word word2) {
        return word1.getSortedWord().equals(word2.getSortedWord());
    }

    public ArrayList<Word> searchAnagrams(String key) {
        ArrayList<Word> anagrams = new ArrayList<Word>();
        Word keyWord = new Word(key);

        for (Word word : wordList) {
            if (checkAnagram(keyWord, word)) {
                anagrams.add(word);
            }
        }
        return anagrams;
    }

    @Override
    public Word get(int index) {
        return wordList.get(index);
    }

    @Override
    public int size() {
        return wordList.size();
    }
}