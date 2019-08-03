class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        
        for (List<String> account : accounts) {
            String name = account.get(0);
            
            for (int i = 1; i < account.size(); i++) {
                graph.computeIfAbsent(account.get(i), k -> new ArrayList<>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), k -> new ArrayList<>()).add(account.get(i));
                emailToName.put(account.get(i), name);
            }
        }
        
        Set<String> visited = new HashSet<>();
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                visited.add(email);
                Stack<String> stack = new Stack<>();
                stack.push(email);
                List<String> singleAccount = new ArrayList<>();
                while (!stack.isEmpty()) {
                    String removed = stack.pop();
                    singleAccount.add(removed);
                    for (String connected : graph.get(removed)) {
                        if (!visited.contains(connected)) {
                            visited.add(connected);
                            stack.push(connected);
                        }
                    }
                }
                Collections.sort(singleAccount);
                singleAccount.add(0, emailToName.get(email));
                mergedAccounts.add(singleAccount);
            }
        }
        
        return mergedAccounts;
    }
}
