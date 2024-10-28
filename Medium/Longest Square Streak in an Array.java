class Solution {

    private static final int LIMIT = 100_000;

    public int longestSquareStreak(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }
        int result = 0;
        for (int num : nums) {
            int currStreak = 0;
            long curr = num;
            while (uniqueNums.contains((int) curr)) {
                currStreak++;
                if (curr * curr > LIMIT) {
                    break;
                }
                curr *= curr;
            }
            result = Math.max(result, currStreak);
        }
        return result < 2 ? -1 : result;
    }
}
