class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int idxOne = 0;
        int idxTwo = 0;
        while (idxOne < str1.length() && idxTwo < str2.length()) {
            if (str1.charAt(idxOne) == str2.charAt(idxTwo) ||
                nextCyclicChar(str1.charAt(idxOne)) == str2.charAt(idxTwo)) {
                idxTwo++;
            } 
            idxOne++;
        }
        return idxTwo == str2.length();
    }
    
    private static char nextCyclicChar(char c) {
        return c == 'z' ? 'a' : (char) (c + 1);
    }
}
