class Solution {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> list = new ArrayList<>();
    int target = graph.length - 1;
    List<Integer> temp = new ArrayList<>();
    temp.add(0);
    helper(list, temp, 0, graph, target);
    return list;
  }
  
  private void helper(List<List<Integer>> list, List<Integer> temp, int curr, int[][] graph, int target) {
    if (curr == target) {
      list.add(new ArrayList<>(temp));
    }
    else {
      int[] connections = graph[curr];
      for (int connection : connections) {
        temp.add(connection);
        helper(list, temp, connection, graph, target);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
