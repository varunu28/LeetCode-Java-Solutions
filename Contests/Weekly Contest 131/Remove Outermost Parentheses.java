class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int prev = 0;
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                count++;
            }    
            else {
                count--;
                if (count == 0) {
                    sb.append(S.substring(prev + 1, i));
                    prev = i + 1;
                }
            }
        }
        
        return sb.toString();
    }
}
