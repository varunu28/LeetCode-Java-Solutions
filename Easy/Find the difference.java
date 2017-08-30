public class Solution {
    public char findTheDifference(String s, String t) {
        String s1 = s;
        String s2 = t;
        s1 = sortString(s1);
        s2 = sortString(s2);

        char ans = '0';

        for (int i=0;i< s1.length();i++) {
            if (s2.charAt(i) != s1.charAt(i)) {
                ans = s2.charAt(i);
                break;
            }
        }
        return ans == '0' ? s2.charAt(s2.length()-1) : ans;
    }
    
    public String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }
}