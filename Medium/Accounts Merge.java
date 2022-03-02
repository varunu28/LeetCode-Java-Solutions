class Solution {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, List<String>> adjacencyList = new HashMap<>();
    for (List<String> account : accounts) {
      String firstEmail = account.get(1);
      for (int i = 2; i < account.size(); i++) {
        adjacencyList.computeIfAbsent(firstEmail, k -> new ArrayList<>()).add(account.get(i));
        adjacencyList.computeIfAbsent(account.get(i), k -> new ArrayList<>()).add(firstEmail);
      }
    }
    Set<String> visited = new HashSet<>();
    List<List<String>> mergedAccounts = new ArrayList<>();
    for (List<String> account : accounts) {
      String name = account.get(0);
      String firstEmail = account.get(1);
      if (!visited.contains(firstEmail)) {
        Stack<String> stack = new Stack<>();
        stack.push(firstEmail);
        List<String> mergedAccount = new ArrayList<>();
        mergedAccount.add(name);
        while (!stack.isEmpty()) {
          String removedEmail = stack.pop();
          visited.add(removedEmail);
          mergedAccount.add(removedEmail);
          for (String neighbor : adjacencyList.getOrDefault(removedEmail, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
              visited.add(neighbor);
              stack.push(neighbor);
            }
          }
        }
        Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
        mergedAccounts.add(mergedAccount);
      }
    }
    return mergedAccounts;
  }
}
