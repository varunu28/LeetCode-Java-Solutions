class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] count = new Map[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            count[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long delta = ((long) nums[i]) - ((long) nums[j]);
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int) delta;
                int sum = count[j].getOrDefault(diff, 0);
                int current = count[i].getOrDefault(diff, 0);
                count[i].put(diff, current + sum + 1);
                result += sum;
            }
        }
        return result;
    }
}
