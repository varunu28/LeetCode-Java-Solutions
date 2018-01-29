class Solution {
    public String convert(String s, int numRows) {
        
        StringBuilder[] sb = new StringBuilder[numRows];
        char[] c = s.toCharArray();
        
        for (int idx=0;idx<sb.length;idx++) {
            sb[idx] = new StringBuilder("");
        }
        
        int i = 0;
        while (i < s.length()) {
            for (int idx=0;idx<numRows && i<s.length(); idx++) {
                sb[idx].append(c[i++]);
            }
            
            for (int idx=numRows-2;idx>=1 && i<s.length(); idx--) {
                sb[idx].append(c[i++]);
            }
        }
        
        for (int j=1;j<sb.length;j++) {
            sb[0].append(sb[j]);
        }
        
        return sb[0].toString();
    }
}
