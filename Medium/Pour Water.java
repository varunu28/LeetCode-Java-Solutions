class Solution {
    public int[] pourWater(int[] heights, int V, int k) {
        while (V-- > 0) {
            int curr = k;
            
            while (curr > 0 && heights[curr] >= heights[curr-1]) {
                curr--;
            }
            
            while (curr < heights.length-1 && heights[curr] >= heights[curr+1]) {
                curr++;
            }
            
            while (curr > k && heights[curr] >= heights[curr-1]) {
                curr--;
            }
            
            heights[curr]++;
        }
        
        return heights;
    }
} 
