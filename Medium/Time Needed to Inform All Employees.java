class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> organization = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) {
                continue;
            }
            organization.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
        }
        int maxTime = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{headID, 0});
        while (!queue.isEmpty()) {
            int[] removed = queue.remove();
            int currManager = removed[0];
            int timeElapsed = removed[1];
            maxTime = Math.max(maxTime, timeElapsed);
            for (Integer employee : organization.getOrDefault(currManager, new ArrayList<>())) {
                queue.add(new int[]{employee, timeElapsed + informTime[currManager]});
            }
        }
        return maxTime;
    }
}
