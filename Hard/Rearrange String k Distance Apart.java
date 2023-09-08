class Solution {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b).compareTo(map.get(a)));
        Queue<Character> busy = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        pq.addAll(map.keySet());
        while (!pq.isEmpty()) {
            Character removed = pq.poll();
            sb.append(removed);
            map.put(removed, map.get(removed) - 1);
            busy.add(removed);
            if (busy.size() < k) {
                continue;
            }
            Character busyRemoved = busy.remove();
            if (map.get(busyRemoved) > 0) {
                pq.add(busyRemoved);
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
