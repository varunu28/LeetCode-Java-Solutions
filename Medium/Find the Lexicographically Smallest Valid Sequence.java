class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] last = new int[m];
        Arrays.fill(last, -1);
        int endIdx = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (endIdx >= 0 && word1.charAt(i) == word2.charAt(endIdx)) {
                last[endIdx--] = i;
            }
        }
        int[] result = new int[m];
        int skip = 0;
        int startIdx = 0;
        for (int i = 0; i < n; i++) {
            if (startIdx == m) {
                break;
            }
            if (word1.charAt(i) == word2.charAt(startIdx) || 
                (skip == 0 && (startIdx == m - 1 || i < last[startIdx + 1]))) {
                skip += word1.charAt(i) != word2.charAt(startIdx) ? 1 : 0;
                result[startIdx++] = i;
            }
        }
        return startIdx == m ? result : new int[0];
    }
}
