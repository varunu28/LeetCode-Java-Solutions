class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int[] result = {-1, -1};
        int resultProd = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int checkValue = target - nums[i];
            if (map.containsKey(checkValue) && nums[i] != checkValue) {
                int prod = nums[i] * checkValue;
                if (prod > resultProd) {
                    if (nums[i] > checkValue) {
                        result[0] = i;
                        result[1] = map.get(checkValue);
                    } else {
                        result[0] = map.get(checkValue);
                        result[1] = i;
                    }
                    resultProd = prod;
                }
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
