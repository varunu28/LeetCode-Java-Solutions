class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> {
            int c = map.get(o2).compareTo(map.get(o1));
            if (c != 0) {
                return c;
            }

            return o1 - o2;
        });
        pq.addAll(map.keySet());

        int count = 0;
        while (!pq.isEmpty()) {
            int jump = n + 1;
            List<Character> temp = new ArrayList<>();
            while (jump > 0 && !pq.isEmpty()) {
                Character polled = pq.poll();
                map.put(polled, map.get(polled) - 1);
                temp.add(polled);
                jump--;
                count++;
            }

            for (Character executedTask : temp) {
                if (map.get(executedTask) > 0) {
                    pq.add(executedTask);
                }
            }

            if (pq.isEmpty()) {
                break;
            }

            count += jump;
        }

        return count;
    }
}
