class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b).compareTo(map.get(a)));
        pq.addAll(map.keySet());
        int count = 0;
        int typeMultiple = 1;
        int counter = 0;
        while (!pq.isEmpty()) {
            char removed = pq.poll();
            count += typeMultiple * map.get(removed);
            counter++;
            if (counter == 8) {
                counter = 0;
                typeMultiple++;
            }
        }
        return count;
    }
}
