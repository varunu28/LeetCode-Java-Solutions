class Solution {
    public char findTheDifference(String s, String t) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (frequency[c - 'a'] == 0) {
                return c;
            }
            frequency[c - 'a']--;
        }
        return ' ';
    }
}
