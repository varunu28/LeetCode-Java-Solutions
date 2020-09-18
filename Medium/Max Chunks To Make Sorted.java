class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSplitCount = 0;
        int maxVal = 0;
        int idx = 0;
        
        while (idx < arr.length) {
            maxVal = Math.max(maxVal, arr[idx]);
            if (maxVal == idx) {
                maxSplitCount++;
            }
            
            idx++;
        }
        
        return maxSplitCount;
    }
}
