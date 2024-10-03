class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p;
        }
        int target = sum % p;
        if (target == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0;
        int result = n; 
        for (int i = 0; i < n; i++) {
            currSum = (currSum + nums[i]) % p;
            int needed = (currSum - target + p) % p;
            if (map.containsKey(needed)) {
                result = Math.min(result, i - map.get(needed));
            }
            map.put(currSum, i);
        }
        return result == n ? -1 : result;
    }
}
