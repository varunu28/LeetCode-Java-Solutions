class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] positions = new int[31];
        Arrays.fill(positions, -1);
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int j = i;
            for (int bit = 0; bit < 31; bit++) {
                if ((nums[i] & (1 << bit)) == 0) {
                    if (positions[bit] != -1) {
                        j = Math.max(j, positions[bit]);
                    }
                } else {
                    positions[bit] = i;
                }
            }
            result[i] = j - i + 1;
        }
        return result;
    }
}
