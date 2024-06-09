class Solution {
    public long numberOfSubstrings(String s) {
        int n = s.length();
        long result = 0;
        long[] prefixCount = new long[26];
        for (int i = 0; i < n; i++) {
            prefixCount[s.charAt(i) - 'a']++;
            result += prefixCount[s.charAt(i) - 'a'];
        }
        return result;
    }
}
