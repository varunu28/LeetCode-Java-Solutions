class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int carry = 0;
        
        while (idx1 >= 0 || idx2 >= 0) {
            int temp = carry;
            if (idx1 >= 0 && idx2 >= 0) {
                temp += (num1.charAt(idx1) - '0') + (num2.charAt(idx2) - '0');
            }
            else if (idx1 >= 0 && idx2 < 0) {
                temp += (num1.charAt(idx1) - '0');
            }
            else {
                temp += (num2.charAt(idx2) - '0');
            }
            
            carry = temp > 9 ? temp / 10 : 0;
            temp = temp > 9 ? temp % 10 : temp;
            sb.append(temp); 
            idx1--;
            idx2--;
        }
        
        sb.append(carry > 0 ? carry : "");
        
        return sb.reverse().toString();
    }
}
