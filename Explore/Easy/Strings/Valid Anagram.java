class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) return false;
        
        int[] ascii = new int[26];
        
        for (int i=0;i<s.length();i++) {
            ascii[(int)s.charAt(i) - 97]++;
        }
        
        for (int i=0;i<t.length();i++) {
            ascii[(int)t.charAt(i) - 97]--;
        }
        
        for (int i=0;i<26;i++) {
            if (ascii[i] != 0) return false;
        }
        
        return true;
    }
}
