class Solution {
  public int[] findingUsersActiveMinutes(int[][] logs, int k) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] log : logs) {
      int id = log[0];
      int minute = log[1];
      map.computeIfAbsent(id, j -> new HashSet<>()).add(minute);
    }
    int[] result = new int[k];
    for (Integer key : map.keySet()) {
      int uam = map.get(key).size();
      result[uam - 1]++;
    }
    return result;
  }
}
