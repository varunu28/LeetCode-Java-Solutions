public class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<n;i++){
            if (sb.toString().indexOf(s.charAt(i)) == -1) {
                sb.append(String.valueOf(s.charAt(i)));
            }
        }
        
        int m = sb.toString().length();
        String sb_s = sb.toString();
        
        for(int i=0;i<m;i++) {
            if (n - s.replace(String.valueOf(sb_s.charAt(i)),"").length() == 1) {
                return s.indexOf(sb_s.charAt(i));
            }
        }
        return -1;
    }
}