class Solution {
  public boolean canFormArray(int[] arr, int[][] pieces) {
    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int idx = 0; idx < arr.length; idx++) {
      indexMap.put(arr[idx], idx);
    }
    for (int[] piece : pieces) {
      for (int idx = 0; idx < piece.length; idx++) {
        if (!indexMap.containsKey(piece[idx]) || 
            idx > 0 && indexMap.getOrDefault(piece[idx], -1) < indexMap.getOrDefault(piece[idx - 1], -1)) {
          return false;
        }
      }
    }
    return true;
  }
}
