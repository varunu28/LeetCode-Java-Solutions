class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.computeIfAbsent(c, k -> new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Map<Character, Boolean> visited = new HashMap<>();
        for (Character c : graph.keySet()) {
            if (dfs(c, graph, sb, visited)) {
                return "";
            }
        }
        return sb.reverse().toString();
    }

    private boolean dfs(Character c, Map<Character, Set<Character>> graph, 
                        StringBuilder sb, Map<Character, Boolean> visited) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }
        visited.put(c, true);
        for (Character neighbor : graph.getOrDefault(c, new HashSet<>())) {
            if (dfs(neighbor, graph, sb, visited)) {
                return true;
            }
        }
        visited.put(c, false);
        sb.append(c);
        return false;
    }
}
