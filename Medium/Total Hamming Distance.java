class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;        
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int j = 0; j < nums.length; j++) {
                bitCount += (nums[j] >> i) & 1;
            }
            
            count += bitCount * (nums.length - bitCount);
        }
        
        return count;
    }
}
