class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0];
            int y = meeting[1];
            int time = meeting[2];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{time, y});
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{time, x});
        }
        int[] earliestTime = new int[n];
        Arrays.fill(earliestTime, Integer.MAX_VALUE);
        earliestTime[0] = 0;
        earliestTime[firstPerson] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); 
        queue.add(new int[]{firstPerson, 0}); 
        while (!queue.isEmpty()) {
            int[] removed = queue.poll();
            int person = removed[0];
            int time = removed[1];
            for (int[] conn : graph.getOrDefault(person, new ArrayList<>())) {
                int t = conn[0];
                int p = conn[1];
                if (t >= time && earliestTime[p] > t) {
                    earliestTime[p] = t;
                    queue.add(new int[]{p, t});
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earliestTime[i] != Integer.MAX_VALUE) {
                result.add(i);
            }
        }
        return result;
    }
}
