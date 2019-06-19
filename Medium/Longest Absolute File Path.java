class Solution {
    public int lengthLongestPath(String input) {
        int maxLen = 0;
        
        // Variables for each iteration
        int currLevel = 1;
        boolean isFile = false;
        int currLen = 0;
        
        // HashMap to store length for each level
        Map<Integer, Integer> map = new HashMap<>();
        
        // Base entry for 0th level
        map.put(0, 0);
        
        int idx = 0;
        int n = input.length();
        while (idx < n) {
            // Keep increasing the level until we find a tab
            while (idx < n && input.charAt(idx) == '\t') {
                idx++;
                currLevel++;
            }
            
            // Keep increasing currLen for the characters in the name
            while (idx < n && input.charAt(idx) != '\n') {
                if (input.charAt(idx) == '.') {
                    isFile = true;
                }
                
                currLen++;
                idx++;
            }
            
            // If isFile then update maxLen else update the value of level in map
            if (isFile) {
                maxLen = Math.max(maxLen, map.get(currLevel - 1) + currLen);
            }
            else {
                map.put(currLevel, map.get(currLevel - 1) + 1 + currLen);
            }
            
            // Reset variables
            currLen = 0;
            currLevel = 1;
            isFile = false;
            idx++;
        }
        
        return maxLen;
    }
}
