class Solution {
    public int[] makeParityAlternating(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return new int[]{0, 0};
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() == 1) {
            return new int[]{n / 2, 1};
        }
        int[] resultOne = solve(nums, false);
        int[] resultTwo = solve(nums, true);
        if (resultOne[0] == resultTwo[0]) {
            return resultOne[1] < resultTwo[1] ? resultOne : resultTwo;
        }
        return resultOne[0] < resultTwo[0] ? resultOne : resultTwo;
    }

    private int[] solve(int[] nums, boolean even) {
        int operations = 0;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int num : nums) {
            if ((num % 2 != 0 && even) || (num % 2 == 0 && !even)) {
                operations++;
                maxValue = Math.max(maxValue, num - 1);
                minValue = Math.min(minValue, num + 1);
            } else {
                maxValue = Math.max(maxValue, num);
                minValue = Math.min(minValue, num);
            }
            even = !even;
        }    
        return new int[]{operations, maxValue - minValue};
    }
}
