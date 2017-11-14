class Solution {
    public int findLHS(int[] nums) {
        
        int max = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        for (int key : map.keySet()) {
            if (map.containsKey(key+1)) {
                max = Math.max(max, map.get(key) + map.get(key+1));
            }
        }
        
        return max;
    }
}
