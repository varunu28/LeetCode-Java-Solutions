class Solution {
    public int romanToInt(String s) {
        String symbol = "IVXLCDM";
        int[] val = {1, 5, 10, 50, 100, 500, 1000};
        
        char[] s_char = s.toCharArray();
        
        int[] s_val = new int[s_char.length];
        
        for (int i=0;i<s_char.length;i++) {
            s_val[i] = val[symbol.indexOf(s_char[i])];
        }
        
        int total = 0;
        int k = 0;
        
        while (k < s_val.length) {
            int s1  = s_val[k];
            if (k+1 < s_val.length) {
                int s2 = s_val[k+1];
                
                if (s1 >= s2) {
                    total += s1;
                    k++;
                }
                else{
                    total += s2-s1;
                    k += 2;
                }
            }
            else {
                total += s1;
                k++;
            }
        }
        
        return total;
    }
}
