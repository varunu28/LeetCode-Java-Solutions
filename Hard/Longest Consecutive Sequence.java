class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int maxLen = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (!set.contains(num - 1)) {
                int current = num;
                int currLen = 1;
                
                while (set.contains(current + 1)) {
                    current += 1;
                    currLen++;
                }
                
                maxLen = Math.max(maxLen, currLen);
            }
        }
        
        return maxLen;
    }
}
