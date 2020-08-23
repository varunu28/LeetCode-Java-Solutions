class Solution {
  public List<Integer> mostVisited(int n, int[] rounds) {
    List<Integer> list = new ArrayList<>();
    int from = rounds[0];
    int to = rounds[rounds.length - 1];
    if (to >= from) {
      for (int i = from; i <= to; i++) {
        list.add(i);
      }
    }
    else {
      for (int i = 1; i <= n; i++) {
        if (i == to + 1) {
          i = from;
        }
        list.add(i);
      }
    }
    return list;
  }
}
