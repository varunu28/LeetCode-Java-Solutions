class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int prev = -1;
            for (int i = 0; i < groupSize; i++) {
                if (pq.isEmpty()) {
                    return false;
                }
                int removed = pq.remove();
                map.put(removed, map.get(removed) - 1);
                if (map.get(removed) > 0) {
                    temp.add(removed);
                }
                if (prev != -1 && removed != prev + 1) {
                    return false;
                }
                prev = removed;
            }
            pq.addAll(temp);
        }
        return true;
    }
}
