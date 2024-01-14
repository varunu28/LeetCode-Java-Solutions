class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] frequencyOne = getFrequencyArray(word1);
        int[] frequencyTwo = getFrequencyArray(word2);
        for (int i = 0; i < 26; i++) {
            if (frequencyOne[i] == 0 && frequencyTwo[i] != 0) {
                return false;
            }
        }
        Arrays.sort(frequencyOne);
        Arrays.sort(frequencyTwo);
        for (int i = 0; i < 26; i++) {
            if (frequencyOne[i] != frequencyTwo[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getFrequencyArray(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        return frequency;
    }
}
