class Solution {
  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < pid.size(); i++) {
      if (ppid.get(i) != 0) {
        map.computeIfAbsent(ppid.get(i), k -> new ArrayList<>()).add(pid.get(i));
      }
    }
    Set<Integer> set = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(kill);
    set.add(kill);
    while (!queue.isEmpty()) {
      int removed = queue.remove();
      set.add(removed);
      for (Integer child : map.getOrDefault(removed, new ArrayList<>())) {
        if (!set.contains(child)) {
          queue.add(child);
          set.add(child);
        }
      }
    }
    return new ArrayList<>(set);
  }
}
