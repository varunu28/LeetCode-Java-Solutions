class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split("\\s+");
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            char lastCharOfCurrentWord = words[i].charAt(words[i].length() - 1);
            char firstCharOfNextWord = words[i + 1].charAt(0);
            if (lastCharOfCurrentWord != firstCharOfNextWord) {
                return false;
            }
        }
        char lastCharOfLastWord = words[n - 1].charAt(words[n - 1].length() - 1);
        char firstCharOfFirstWord = words[0].charAt(0);
        return lastCharOfLastWord == firstCharOfFirstWord;
    }
}
