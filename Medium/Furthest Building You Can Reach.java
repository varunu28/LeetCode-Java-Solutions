class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                pq.add(diff);
                bricks -= diff;
                if (bricks < 0) {
                    if (ladders == 0) {
                        return i - 1;
                    }
                    ladders--;
                    bricks += pq.poll();
                }
            }
        }
        return heights.length - 1;
    }
}
