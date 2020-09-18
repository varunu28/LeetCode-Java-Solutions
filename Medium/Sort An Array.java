class Solution {
    public int[] sortArray(int[] nums) {
        int[] counter = new int[2 * 50000 + 1];
        for (int num : nums) {
            counter[50000 + num]++;
        }
        
        int idx = 0;
        for (int i = 0; i < counter.length; i++) {
            int val = i > 50000 ? i - 50000 : -(50000 - i);
            while (counter[i]-- > 0) {
                nums[idx++] = val;
            }
        }
        
        return nums;
    }
}
