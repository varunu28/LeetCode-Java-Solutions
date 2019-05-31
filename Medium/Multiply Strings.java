class Solution {
    public String multiply(String num1, String num2) {
        // Initial array of n * m size
        int n = num1.length();
        int m = num2.length();
        int[] ans = new int[n + m];
        
        // Multiple both strings from end and store it in the array
        // Keep decreasing end size by one for each iteration
        int idx = ans.length - 1;
        int carry = 0;
        int tempIdx = idx;
        
        for (int i = n - 1; i >= 0; i--) {
            tempIdx = idx;
            for (int j = m - 1; j >= 0; j--) {
                char a = num1.charAt(i);
                char b = num2.charAt(j);
                
                int mul = ans[tempIdx] + multiplyChars(a, b) + carry;
                if (mul > 9) {
                    carry = mul / 10;
                    mul = mul % 10;
                }
                else {
                    carry = 0;
                }
                
                ans[tempIdx] = mul;
                tempIdx--;
            }
            
            // Continue adding carry if present else reset carry
            while (carry > 0) {
                int mul = ans[tempIdx] + carry;
                if (mul > 9) {
                    carry = mul / 10;
                    mul = mul % 10;
                }
                else {
                    carry = 0;
                }
                
                ans[tempIdx--] = mul;
            }
            
            idx--;
        }
        
        // Remove initial zeros
        int zeroIdx = 0;
        while (zeroIdx < ans.length && ans[zeroIdx] == 0 ) {
            zeroIdx++;
        }
        
        // Convert array to string and return
        StringBuilder sb = new StringBuilder();
        for (int i = zeroIdx; i < ans.length; i++) {
            sb.append(ans[i]);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
    private int multiplyChars(char a, char b) {
        return Character.getNumericValue(a) * Character.getNumericValue(b); 
    }
}
