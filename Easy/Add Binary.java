class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int idx1 = a.length() - 1;
        int idx2 = b.length() - 1;
        
        while (idx1 >= 0 && idx2 >= 0) {
            if (a.charAt(idx1) == '1' && b.charAt(idx2) == '1') {
                sb.append(carry == 1 ? 1 : 0);
                carry = 1;
            }
            else if (a.charAt(idx1) == '1' || b.charAt(idx2) == '1') {
                sb.append(carry == 0 ? 1 : 0);
            }
            else {
                sb.append(carry);
                carry = 0;
            }
            
            idx1--;
            idx2--;
        }
        
        String remainingString = a.length() > b.length() ? a : b;
        int idx = Math.max(idx2, idx1);
        while (idx >= 0) {
            if (remainingString.charAt(idx) == '1') {
                sb.append(carry == 1 ? 0 : 1);
            }
            else {
                sb.append(carry);
                carry = 0;
            }
            
            idx--;
        }
        
        if (carry > 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}
