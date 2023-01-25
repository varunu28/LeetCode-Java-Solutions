class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] distance1 = new int[n];
        int[] distance2 = new int[n];
        Arrays.fill(distance1, Integer.MAX_VALUE);
        Arrays.fill(distance2, Integer.MAX_VALUE);
        bfs(node1, edges, distance1);
        bfs(node2, edges, distance2);
        int minDistanceNode = -1;
        int currMinDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (currMinDistance > Math.max(distance1[i], distance2[i])) {
                minDistanceNode = i;
                currMinDistance = Math.max(distance1[i], distance2[i]);
            }
        }
        return minDistanceNode;
    }
    
    private void bfs(int startNode, int[] edges, int[] distance) {
        int n = edges.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        boolean[] visited = new boolean[n];
        distance[startNode] = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            int neighbor = edges[node];
            if (neighbor != -1 && !visited[neighbor]) {
                distance[neighbor] = 1 + distance[node];
                queue.add(neighbor);
            }
        }
    }
}
