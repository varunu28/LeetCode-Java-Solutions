class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        Map<String, Set<String>> map = new HashMap<>();

        for (List<String> pair : pairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);

            map.computeIfAbsent(word1, k -> new HashSet<String>()).add(word2);
            map.computeIfAbsent(word2, k -> new HashSet<String>()).add(word1);
        }

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < words1.length && idx2 < words2.length) {
            if (words1[idx1].equals(words2[idx2])) {
                idx1++;
                idx2++;
                continue;
            }

            if (!dfs(map, words1[idx1], words2[idx2])) {
                return false;
            }

            idx1++;
            idx2++;
        }

        return idx1 == words1.length && idx2 == words2.length;
    }

    private boolean dfs(Map<String, Set<String>> map, String s, String t) {
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();

        stack.push(s);
        visited.add(s);

        while (!stack.isEmpty()) {
            String word = stack.pop();
            if (word.equals(t)) {
                return true;
            }
            if (map.containsKey(word)) {
                Iterator<String> iterator = map.get(word).iterator();
                while (iterator.hasNext()) {
                    String temp = iterator.next();
                    if (!visited.contains(temp)) {
                        stack.push(temp);
                        visited.add(temp);
                    }
                }
            }
        }

        return false;
    }
}
