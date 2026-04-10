public class AnagramListTester {
    public static void main(String[] args) {
        AnagramList anagramList = new AnagramList();
        
        Word word1 = new Word("listen");
        Word word2 = new Word("silent");
        Word word3 = new Word("enlist");
        Word word4 = new Word("inlets");
        Word word5 = new Word("google");

        anagramList.add(word1);
        anagramList.add(word2);
        anagramList.add(word3);
        anagramList.add(word4);
        anagramList.add(word5);

        System.out.println("Anagrams of 'listen': " + anagramList.searchAnagrams("listen"));
    }
}
