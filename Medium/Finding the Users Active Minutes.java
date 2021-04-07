class Solution {
  public int[] findingUsersActiveMinutes(int[][] logs, int k) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<Set<Integer>> setList = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      setList.add(new HashSet<>());
    }
    for (int[] log : logs) {
      map.computeIfAbsent(log[0], j -> new HashSet<>()).add(log[1]);
      int currActiveTime = map.get(log[0]).size();
      if (currActiveTime <= k) {
        setList.get(currActiveTime - 1).add(log[0]);
        if (currActiveTime != 1) {
          setList.get(currActiveTime - 2).remove(log[0]);
        }
      }
    }
    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = setList.get(i).size();
    }
    return ans;
  }
}
