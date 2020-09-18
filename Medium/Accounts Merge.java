class Solution {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, String> emailToNameMap = new HashMap<>();
    Map<String, Set<String>> graph = new HashMap<>();
    for (List<String> account : accounts) {
      String name = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        emailToNameMap.put(account.get(i), name);
        graph.computeIfAbsent(account.get(i), k -> new HashSet<>()).add(account.get(1));
        graph.computeIfAbsent(account.get(1), k -> new HashSet<>()).add(account.get(i));
      }
    }
    Set<String> seen = new HashSet<>();
    List<List<String>> ans = new ArrayList<>();
    for (String email : graph.keySet()) {
      if (!seen.contains(email)) {
        seen.add(email);
        Stack<String> stack = new Stack<>();
        stack.push(email);
        List<String> component = new ArrayList<>();
        while (!stack.isEmpty()) {
          String node = stack.pop();
          component.add(node);
          for (String neighbour : graph.get(node)) {
            if (!seen.contains(neighbour)) {
              seen.add(neighbour);
              stack.push(neighbour);
            }
          }
        }
        Collections.sort(component);
        component.add(0, emailToNameMap.get(email));
        ans.add(component);
      }
    }
    return ans;
  }
}
