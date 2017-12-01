class Solution {
    public int compress(char[] chars) {
        
        int ans = 0;
        int ind = 0;
        
        while (ind < chars.length) {
            char currChar = chars[ind];
            int count = 0;
            
            while(ind < chars.length && chars[ind] == currChar) {
                ind++;
                count++;
            }
            
            chars[ans++] = currChar;
            
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[ans++] = c;
                }
            }
        }
        
        return ans;
    }
}
