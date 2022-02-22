class Solution {
  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < pid.size(); i++) {
      map.computeIfAbsent(ppid.get(i), k -> new HashSet<>()).add(pid.get(i));
    }
    Stack<Integer> stack = new Stack<>();
    stack.push(kill);
    Set<Integer> tasksKilled = new HashSet<>();
    while (!stack.isEmpty()) {
      int removedTask = stack.pop();
      tasksKilled.add(removedTask);
      for (Integer childTask : map.getOrDefault(removedTask, new HashSet<>())) {
        if (!tasksKilled.contains(childTask)) {
          stack.push(childTask);
        }
      }
    }
    return new ArrayList<>(tasksKilled);
  }
}
