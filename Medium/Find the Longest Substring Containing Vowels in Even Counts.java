class Solution {
    public int findTheLongestSubstring(String s) {
        int prefixXor = 0;
        char[] frequency = new char[26];
        frequency['a' - 'a'] = 1;
        frequency['e' - 'a'] = 2;
        frequency['i' - 'a'] = 4;
        frequency['o' - 'a'] = 8;
        frequency['u' - 'a'] = 16;
        int[] indexMap = new int[32];
        Arrays.fill(indexMap, -1);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            prefixXor ^= frequency[s.charAt(i) - 'a'];
            if (indexMap[prefixXor] == -1 && prefixXor != 0) {
                indexMap[prefixXor] = i;
            }
            result = Math.max(result, i - indexMap[prefixXor]);
        }
        return result;
    }
}
