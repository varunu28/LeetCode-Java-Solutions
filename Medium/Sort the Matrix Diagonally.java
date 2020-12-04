class Solution {
  public int[][] diagonalSort(int[][] mat) {
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        map.computeIfAbsent(i - j, k -> new PriorityQueue<>()).add(mat[i][j]);
      }
    }
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        mat[i][j] = map.get(i - j).poll();
      }
    }
    return mat;
  }
}
