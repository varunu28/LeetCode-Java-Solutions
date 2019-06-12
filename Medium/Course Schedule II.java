class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.computeIfAbsent(prerequisite[0], k -> new ArrayList<>()).add(prerequisite[1]);
        }

        boolean[] registered = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!isDeadlock(i, map, stack, registered, new boolean[numCourses])) {
                return new int[]{};
            }
        }

        int[] ans = new int[numCourses];
        int idx = numCourses - 1;
        while (!stack.isEmpty()) {
            ans[idx--] = stack.pop();
        }

        return ans;
    }

    private boolean isDeadlock(int c1, Map<Integer, List<Integer>> map, Stack<Integer> stack, boolean[] registered, boolean[] visited) {
        if (registered[c1]) {
            return true;
        }

        if (visited[c1]) {
            return false;
        }

        visited[c1] = true;
        for (Integer prereq : map.getOrDefault(c1, new ArrayList<>())) {
            if (!isDeadlock(prereq, map, stack, registered, visited)) {
                return false;
            }
        }

        registered[c1] = true;
        stack.push(c1);

        return true;
    }

}
