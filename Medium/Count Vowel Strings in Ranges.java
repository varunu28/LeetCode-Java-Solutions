class Solution {
    
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] counter = new int[words.length];
        int currCounter = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                currCounter++;
            }
            counter[i] = currCounter;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = counter[right];
            result[i] -= left == 0 ? 0 : counter[left - 1];
        }
        return result;
    }
    
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
