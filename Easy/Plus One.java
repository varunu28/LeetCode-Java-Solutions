class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry = 1;
        List<Integer> ans = new ArrayList<>();
        
        for (int i=digits.length-1;i>=0;i--) {
            if (digits[i] == 9 && carry == 1) {
                ans.add(0);
                carry  = 1;
            }
            else if (carry == 1) {
                ans.add(digits[i]+carry);
                carry = 0;
            }
            else {
                ans.add(digits[i]+carry);
            }
        }
        
        if (carry!=0) {
            ans.add(carry);
        }
        
        Collections.reverse(ans);
        
        int [] a = new int[ans.size()];
        
        for (int k=0; k<ans.size();k++) {
            a[k] = ans.get(k);
        }
        
        return a;
    }
}
