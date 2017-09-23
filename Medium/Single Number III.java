class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 2);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        
        int[] ans = new int[2];
        int j = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                if (j == 0) {
                    ans[j] = entry.getKey();
                    j++;
                }
                else {
                    ans[j] = entry.getKey();
                    break;
                }
            }
        }
        
        return ans;
    }
}
