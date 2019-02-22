class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Entry> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).degree++;
                map.get(nums[i]).endIdx = i;
            }
            else {
                map.put(nums[i], new Entry(1, i, i));
            }
        }
        
        int res = Integer.MAX_VALUE;
        int degree = Integer.MIN_VALUE;
        
        for (Entry entry : map.values()) {
            if (degree < entry.degree) {
                degree = entry.degree;
                res = entry.endIdx - entry.startIdx + 1;
            }    
            else if (degree == entry.degree) {
                res = Math.min(entry.endIdx - entry.startIdx + 1, res);
            }
        }
        
        return res;
    }

    class Entry {
        int degree;
        int startIdx;
        int endIdx;
        
        public Entry(int degree, int startIdx, int endIdx) {
            this.degree = degree;
            this.startIdx = startIdx;
            this.endIdx = endIdx;
        }
    }
}
