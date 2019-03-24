class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int maxVal = 0;
        int currMax = 0;
        
        for (int spot : A) {
            maxVal = Math.max(maxVal, currMax + spot);
            currMax = Math.max(spot, currMax) - 1;
        }
        
        return maxVal;
    }
}
