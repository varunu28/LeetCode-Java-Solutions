class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a).compareTo(map.get(b)));
        pq.addAll(map.keySet());
        while (k > 0 && !pq.isEmpty()) {
            int count = map.get(pq.peek());
            if (count > k) {
                break;
            }
            k -= count;
            pq.poll();
        }
        return pq.size();
    }
}
