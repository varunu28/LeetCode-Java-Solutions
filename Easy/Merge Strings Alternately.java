class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int idxOne = 0;
        int idxTwo = 0;
        while (idxOne < word1.length() || idxTwo < word2.length()) {
            if (idxOne < word1.length()) {
                sb.append(word1.charAt(idxOne++));
            }
            if (idxTwo < word2.length()) {
                sb.append(word2.charAt(idxTwo++));
            }
        }
        return sb.toString();
    }
}
