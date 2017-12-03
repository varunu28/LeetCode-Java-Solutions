class Solution {
    public int arrangeCoins(int n) {
        long j = 1;
        long sum = 0;
    
        int ans = 0;
        while (true) {
            sum += j;
            if (sum <= n) {
                ans++;
            } 
            else {
                break;
            }
            j++;
        }
        
        return ans;
    }
}
