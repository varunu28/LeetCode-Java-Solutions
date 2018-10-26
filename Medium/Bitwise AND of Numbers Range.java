class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int temp1 = m;
        int temp2 = n;
        
        int cnt1 = 0;
        int cnt2 = 0;
        
        while (temp1 > 1 || temp2 > 1) {
            if (temp1 > 1) {
                temp1 /= 2;
                cnt1++;
            }     
            
            if (temp2 > 1) {
                temp2 /= 2;
                cnt2++;
            } 
        }
        
        if (cnt1 != cnt2) {
            return 0;
        }
        
        int res = ~0;
        for (int i=m;i<n;i++) {
            res = res&i;
        }
        
        res = res&n;
        
        return res;
    }
}
