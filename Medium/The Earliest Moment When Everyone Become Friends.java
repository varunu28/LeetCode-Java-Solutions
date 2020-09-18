class Solution {
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] log : logs) {
            boolean[] allDone = {false};
            map.computeIfAbsent(log[1], k -> new HashSet<>()).add(log[2]);
            dfs(map, log[1], log[2], allDone, N);

            map.computeIfAbsent(log[2], k -> new HashSet<>()).add(log[1]);
            dfs(map, log[2], log[1], allDone, N);


            if (allDone[0]) {
                return log[0];
            }
        }

        return -1;
    }

    private void dfs(Map<Integer, Set<Integer>> map, int f1, int f2, boolean[] allDone, int N) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(f1);
        visited.add(f1);

        while (!queue.isEmpty()) {
            int removed = queue.poll();
            Iterator<Integer> iterator = map.getOrDefault(removed, new HashSet<>()).iterator();
            while (iterator.hasNext()) {
                int friend = iterator.next();
                if (!visited.contains(friend)) {
                    queue.add(friend);
                    map.computeIfAbsent(friend, k -> new HashSet<>()).add(f2);
                    map.computeIfAbsent(f2, k -> new HashSet<>()).add(friend);

                    if (map.get(f2).size() == N || map.get(friend).size() == N) {
                        allDone[0] = true;
                    }

                    visited.add(friend);
                }
            }
        }
    }
}
