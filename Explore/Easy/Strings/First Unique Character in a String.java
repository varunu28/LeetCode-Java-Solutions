class Solution {
    public int firstUniqChar(String s) {
        int[] ascii = new int[26];
        
        for (int i=0;i<s.length();i++) {
            ascii[(int)s.charAt(i) - 97]++;
        }
        
        for (int i=0;i<s.length();i++) {
            if (ascii[(int)s.charAt(i) - 97] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}
