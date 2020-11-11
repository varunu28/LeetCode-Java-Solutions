class Solution {
  public int[] processQueries(int[] queries, int m) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 1; i <= m; i++) {
      list.add(i);
    }
    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int idx = list.indexOf(queries[i]);
      result[i] = idx;
      list.remove(idx);
      list.addFirst(queries[i]);
    }
    return result;
  }   
}
