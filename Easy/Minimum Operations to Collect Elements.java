class Solution {
    public int minOperations(List<Integer> nums, int k) {
        boolean[] found = new boolean[k];
        int foundCount = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) <= k && !found[nums.get(i) - 1]) {
                found[nums.get(i) - 1] = true;
                foundCount++;
            }
            if (foundCount == k) {
                return nums.size() - i;
            }
        }
        return -1;
    }
}
