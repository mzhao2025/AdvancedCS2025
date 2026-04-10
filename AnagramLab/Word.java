public class Word {
    private String originalWord;
    private String sortedWord;

    public Word(String word) {
        this.originalWord = word;
        this.sortedWord = sortWord(word);
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public String getSortedWord() {
        return sortedWord;
    }

    public String sortWord(String word) {
        word = word.toLowerCase();
        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            char temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return new String(arr);
    }

    public String toString() {
        return originalWord;
    }
}