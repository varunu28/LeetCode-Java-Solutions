class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String s1 = s + s;
        String s2 = s1.substring(1,s1.length()-1);
        
        return s2.contains(s);
    }
}
