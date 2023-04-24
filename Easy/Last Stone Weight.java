class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int stoneOne = pq.poll();
            int stoneTwo = pq.poll();
            if (stoneOne != stoneTwo) {
                pq.add(stoneOne - stoneTwo);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
