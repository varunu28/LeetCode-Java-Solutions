class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] frequency = new int[101];
        int maxFrequency = 0;
        for (int num : nums) {
            frequency[num]++;
            maxFrequency = Math.max(maxFrequency, frequency[num]);
        }
        int[] ans = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < maxFrequency; i++) {
            for (int j = 1; j <= 100; j++) {
                if (frequency[j] > 0) {
                    ans[idx++] = j;
                    frequency[j]--;
                }
            }
        }
        return ans;
    }
}
