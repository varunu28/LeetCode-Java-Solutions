class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n + 1];
        for (int[] relation : relations) {
            int course = relation[0];
            int prereq = relation[1];
            indegree[course]++;
            map.computeIfAbsent(prereq, k -> new ArrayList<>()).add(course);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] maxTime = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                maxTime[i] = time[i - 1];
            }
        }
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (Integer dependent : map.getOrDefault(removed, new ArrayList<>())) {
                maxTime[dependent] = Math.max(maxTime[dependent], maxTime[removed] + time[dependent - 1]);
                indegree[dependent]--;
                if (indegree[dependent] == 0) {
                    queue.add(dependent);
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, maxTime[i]);
        }
        return result;
    }
}
