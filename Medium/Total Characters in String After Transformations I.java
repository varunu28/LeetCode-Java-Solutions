class Solution {

    private static final int MOD = 1000_0000_07;

    public int lengthAfterTransformations(String s, int t) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        for (int round = 0; round < t; round++) {
            int[] next = new int[26];
            next[0] = frequency[25]; // Transformation from 'z'
            next[1] = (frequency[25] + frequency[0]) % MOD; // Transformation from either 'z' or 'a'
            for (int i = 2; i < 26; i++) {
                next[i] = frequency[i - 1]; // Transformation for next character
            }
            frequency = next;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + frequency[i]) % MOD;
        }
        return result;
    }
}
