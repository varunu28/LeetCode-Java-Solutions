class Solution {
  private final Integer RED = 1;
  private final Integer BLUE = 2;
  public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
    Map<Integer, List<Connection>> map = new HashMap<>();
    for (int[] edge : red_edges) {
      map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Connection(edge[1], RED));
    }
    for (int[] edge : blue_edges) {
      map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Connection(edge[1], BLUE));
    }
    int[] distances = new int[n];
    for (int i = 1; i < n; i++) {
      distances[i] = getDistance(map, i, n);
    }
    return distances;
  }
  
  private int getDistance(Map<Integer, List<Connection>> map, int target, int n) {
    int curr = 0;
    int steps = 0;
    boolean found = false;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[2][n];
    queue.add(new int[]{0, -1});
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] removed = queue.remove();
        if (removed[0] == target) {
          found = true;
          break;
        }
        int color = removed[1];
        for (Connection connection : map.getOrDefault(removed[0], new ArrayList<>())) {
          if (color == -1 && !visited[connection.color - 1][connection.val]) {
            visited[connection.color - 1][connection.val] = true;
            queue.add(connection.getArray());
          }
          else if (color == 1 && connection.color != 1 && !visited[connection.color - 1][connection.val]) {
            visited[connection.color - 1][connection.val] = true;
            queue.add(connection.getArray());
          }
          else if (color == 2 && connection.color != 2 && !visited[connection.color - 1][connection.val]) {
            visited[connection.color - 1][connection.val] = true;
            queue.add(connection.getArray());
          }
        }
      }
      if (found) {
        break;
      }
      steps++;
    }
    return found ? steps : -1;
  }
}


class Connection {
  int val;
  int color;
  
  public Connection(int val, int color) {
    this.val = val;
    this.color = color;
  }
  
  public int[] getArray() {
    return new int[]{this.val, this.color};
  }
}
