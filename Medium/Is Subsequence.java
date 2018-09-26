class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        
        int i=0;
        int j=0;
        int low = s.length();
        int high = t.length();
        
        while(i<low && j<high) {
            if (sChar[i] == tChar[j]) {
                i++;
            }
            
            j++;
        }
        
        return i == low;
    }
}
