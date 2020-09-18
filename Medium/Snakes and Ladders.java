class Solution {
  public int snakesAndLadders(int[][] board) {
    int n = board.length;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 0);
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    while (!queue.isEmpty()) {
      int s = queue.remove();
      if (s == n * n) {
        return map.get(s);
      }
      for (int i = s + 1; i <= Math.min(s + 6, n * n); i++) {
        int rc = helper(i, n);
        int r = rc / n;
        int c = rc % n;
        int point = board[r][c] == -1 ? i : board[r][c];
        if (!map.containsKey(point)) {
          map.put(point, map.get(s) + 1);
          queue.add(point);
        }
      }
    }
    return -1;
  }
  
  public int helper(int s, int N) {
    int quot = (s - 1) / N;
    int rem = (s - 1) % N;
    int row = N - 1 - quot;
    int col = row % 2 != N % 2 ? rem : N - 1 - rem;
    return row * N + col;
  }
}
