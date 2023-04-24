class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());
        int cycles = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // Wait for one cooldown period and process one occurrence of all remaining tasks
            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.remove());
                }
            }
            // If task has more occurrences left then add it back to heap
            for (int task : temp) {
                if (task > 1) {
                    pq.add(task - 1);
                }
            }
            // If heap is empty that means we finished all tasks and don't need to wait for 
            // the whole cooldown to finish else add one complete cooldown period
            cycles += pq.isEmpty() ? temp.size() : n + 1;
        }
        return cycles;
    }
}
