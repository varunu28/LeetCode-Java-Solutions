class Solution {
  public boolean canReach(int[] arr, int start) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    queue.add(start);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int removed = queue.remove();
        if (arr[removed] == 0) {
          return true;
        }
        if (visited.contains(removed)) {
          continue;
        }
        visited.add(removed);
        if (removed + arr[removed] < arr.length) {
          queue.add(removed + arr[removed]);
        }
        if (removed - arr[removed] >= 0) {
          queue.add(removed - arr[removed]);
        }
      }
    }
    return false;
  }
}
