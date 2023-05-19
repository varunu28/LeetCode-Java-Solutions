class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !isBipartite(graph, i, color)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isBipartite(int[][] graph, int node, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        int currColor = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int removed = queue.remove();
                if (color[removed] != 0) {
                    if (color[removed] != currColor) {
                        return false;
                    }
                } else {
                    color[removed] = currColor;
                    for (int conn : graph[removed]) {
                        if (color[conn] == 0) {
                            queue.add(conn);
                        }
                    }
                }
            }
            currColor = currColor == 1 ? 2 : 1;
        }
        return true;
    }
}
