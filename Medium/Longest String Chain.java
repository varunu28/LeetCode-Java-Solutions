class Solution {
    public int longestStrChain(String[] words) {
        Set<String> wordSet = Arrays.stream(words)
        .collect(Collectors.toSet());
        Map<String, Integer> memo = new HashMap<>();
        int result = 0;
        for (String word : words) {
            result = Math.max(result, dfs(wordSet, memo, word));
        }
        return result;
    }

    private int dfs(Set<String> wordSet, Map<String, Integer> memo, String word) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if (wordSet.contains(newWord)) {
                int currLength = 1 + dfs(wordSet, memo, newWord);
                maxLength = Math.max(maxLength, currLength);
            }
            sb.insert(i, word.charAt(i));
        }
        memo.put(word, maxLength);
        return maxLength;
    }
}
