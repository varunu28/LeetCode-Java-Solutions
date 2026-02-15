class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        while (volume-- > 0) {
            boolean foundBest = false;
            for (int d = -1; d <= 1 && !foundBest; d += 2) {
                int idx = k;
                int best = k;
                while (idx + d >= 0 && idx + d < heights.length && heights[idx + d] <= heights[idx]) {
                    if (heights[idx + d] < heights[idx]) {
                        best = idx + d;
                    }
                    idx += d;
                }
                if (heights[best] < heights[k]) {
                    heights[best]++;
                    foundBest = true;
                }
            }
            if (!foundBest) {
                heights[k]++;
            }
        }
        return heights;
    }
}
