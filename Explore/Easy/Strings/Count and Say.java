class Solution {
    public String countAndSay(int n) {
        String first = "1";
        String str = "11";
        
        if (n == 1) return first;
        if (n == 2) return str;
        
        for (int i = 3; i<=n; i++) {
            str += "$";
            int len = str.length();

            int cnt = 1; 
            String  tmp = ""; 
            
            for (int j = 1; j < len; j++) {
                if (str.charAt(j) != str.charAt(j-1)) {
                    tmp += String.valueOf(cnt);
                    tmp += str.charAt(j-1);

                    cnt = 1;
                }

                else cnt++;
            }

            str = tmp;
        }
        
        return str;
    }
}
