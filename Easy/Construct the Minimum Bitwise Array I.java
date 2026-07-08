class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            int result = -1;
            for (int j = 1; j < num; j++) {
                if ((j | (j + 1)) == num) {
                    result = j;
                    break;
                }
            }
            ans[i] = result;
        }
        return ans;
    }
}
