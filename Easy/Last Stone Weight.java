class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            int resSize = Math.max(stone1, stone2) - Math.min(stone1, stone2);

            if (resSize > 0) {
                pq.add(resSize);
            }
        }

        return pq.size() == 1 ? pq.poll() : 0;
    }
}
