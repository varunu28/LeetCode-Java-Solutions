class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] upperPresent = new boolean[26];
        boolean[] lowerPresent = new boolean[26];
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperPresent[c - 'A'] = true;
            } else {
                lowerPresent[c - 'a'] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (upperPresent[i] && lowerPresent[i]) {
                count++;
            }
        }
        return count;
    }
}
