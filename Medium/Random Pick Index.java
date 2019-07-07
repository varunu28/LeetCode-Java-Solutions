class Solution {
    Map<Integer, List<Integer>> map = new HashMap();
    Random rand;
    public Solution(int[] nums) {
        rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> indexes = map.get(target);
        return indexes.get(rand.nextInt(indexes.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
