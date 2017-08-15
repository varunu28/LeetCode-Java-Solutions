public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i=1;i<sum.length;i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        double maxAvg = sum[k-1]*1.0/k;
        for (int i=k;i<sum.length;i++) {
            maxAvg = Math.max(maxAvg, (sum[i] - sum[i-k])*1.0/k);
        }
        return maxAvg;
    }
}