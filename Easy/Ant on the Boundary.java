class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int currPosition = 0;
        int count = 0;
        for (int num : nums) {
            currPosition += num;
            if (currPosition == 0) {
                count++;
            }
        }
        return count;
    }
}
