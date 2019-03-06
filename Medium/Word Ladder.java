class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int l = beginWord.length();
        Map<String, List<String>> combMap = new HashMap<>();
        
        for (String word : wordList) {
            for (int i = 0; i < l; i++) {
                String wildCardWord = word.substring(0, i) + "*" + word.substring(i + 1, l);
                combMap.computeIfAbsent(wildCardWord, k -> new ArrayList<>()).add(word);
            }
        }
        
        Queue<WordLevel> queue = new LinkedList<>();
        queue.add(new WordLevel(beginWord, 1));
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            WordLevel removed = queue.remove();
            String word = removed.word;
            int level = removed.level;
            
            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1);
                
                for (String wildCardWord : combMap.getOrDefault(newWord, new ArrayList<>())) {
                    if (wildCardWord.equals(endWord)) {
                        return level + 1;
                    }
                    
                    if (!visited.contains(wildCardWord)) {
                        visited.add(wildCardWord);
                        queue.add(new WordLevel(wildCardWord, level + 1));
                    }
                }
            }
        }
        
        return 0;
    }
}

class WordLevel {
    String word;
    int level;
    
    public WordLevel(String word, int level) {
        this.word = word;
        this.level = level;
    }
}
