class Solution {
  public String tictactoe(int[][] moves) {
    int n = 3;
    Map<Integer, Map<Character, Integer>> rowMap = new HashMap<>();
    Map<Integer, Map<Character, Integer>> colMap = new HashMap<>();
    Map<Character, Integer> rightDiagMap = new HashMap<>();
    Map<Character, Integer> leftDiagMap = new HashMap<>();
    for (int i = 0; i < moves.length; i++) {
      int x = moves[i][0];
      int y = moves[i][1];
      char move = i % 2 == 0 ? 'X' : 'O';
      String player = i % 2 == 0 ? "A" : "B";
      Map<Character, Integer> row = rowMap.computeIfAbsent(x, k -> new HashMap<>());
      row.put(move, row.getOrDefault(move, 0) + 1);
      if (row.get(move) == 3) {
        return player;
      }
      Map<Character, Integer> col = colMap.computeIfAbsent(y, k -> new HashMap<>());
      col.put(move, col.getOrDefault(move, 0) + 1);
      if (col.get(move) == 3) {
        return player;
      }
      if (x == y) {
        leftDiagMap.put(move, leftDiagMap.getOrDefault(move, 0) + 1);
        if (leftDiagMap.get(move) == 3) {
          return player;
        }
      }
      if (x + y == n - 1) {
        rightDiagMap.put(move, rightDiagMap.getOrDefault(move, 0) + 1);
        if (rightDiagMap.get(move) == 3) {
          return player;
        }
      }
    }
    return moves.length == n * n ? "Draw" : "Pending";
  }
}
