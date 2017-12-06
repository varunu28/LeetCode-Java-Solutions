class Solution {
    public String addBinary(String a, String b) {
        int maxL = Math.max(a.length(), b.length());
        
        if (a.length() < maxL) {
            a = String.join("", Collections.nCopies(maxL - a.length(), "0")) + a;
        }
        
        if (b.length() < maxL) {
            b = String.join("", Collections.nCopies(maxL - b.length(), "0")) + b;
        }
        
        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        
        for (int i=a.length()-1;i>=0;i--) {
            if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                if (carry == 1) {
                    sb.append("1");
                }
                else {
                    sb.append("0");
                }
                
                carry  = 1;
            }
            
            else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                sb.append(String.valueOf(carry));
                carry = 0;
            }
            
            else if (a.charAt(i) != b.charAt(i)) {
                if (carry == 1) {
                    sb.append("0");
                }
                else {
                    sb.append("1");
                }
            }
        }
        
        if (carry == 1) {
            sb.append("1");
        }
        
        return sb.reverse().toString();
    }
}
