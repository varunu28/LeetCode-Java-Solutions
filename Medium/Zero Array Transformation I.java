class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            diff[left] += 1;
            diff[right + 1] -= 1;
        }
        int[] operation = new int[n + 1];
        int currOperation = 0;
        for (int i = 0; i < n + 1; i++) {
            currOperation += diff[i];
            operation[i] = currOperation;
        }
        for (int i = 0; i < n; i++) {
            if (operation[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
