class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] dislike : dislikes) {
            map.computeIfAbsent(dislike[0], k -> new ArrayList<>()).add(dislike[1]);
            map.computeIfAbsent(dislike[1], k -> new ArrayList<>()).add(dislike[0]);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!bfs(i, map, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean bfs(int node, Map<Integer, List<Integer>> map, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 0;
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (Integer neighbor : map.getOrDefault(removed, new ArrayList<>())) {
                if (color[neighbor] == color[removed]) {
                    return false;
                }
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[removed];
                    queue.add(neighbor);
                }
            }
        }
        return true;
    }
}
