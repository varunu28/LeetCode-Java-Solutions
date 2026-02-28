class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int[] frequency = new int[101];
        for (int num : nums) {
            frequency[num]++; 
        }
        int previous = -1;
        for (int i = 1; i <= 100; i++) {
            if (frequency[i] == 0) {
                continue;
            }
            if (previous == -1) {
                previous = i;
            } else {
                if (frequency[i] != frequency[previous]) {
                    return new int[]{previous, i};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
