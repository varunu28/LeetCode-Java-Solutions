class Solution {
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> map = new HashMap<>();
        for (String idea : ideas) {
            map.computeIfAbsent(idea.charAt(0), k -> new HashSet<>()).add(idea.substring(1, idea.length()));
        }
        long result = 0;
        for (Character key1 : map.keySet()) {
            for (Character key2 : map.keySet()) {
                if (key1 == key2) {
                    continue;
                }
                int intersection = 0;
                for (String word : map.get(key1)) {
                    if (map.get(key2).contains(word)) {
                        intersection++;
                    }
                }
                int distinctOne = map.get(key1).size() - intersection;
                int distinctTwo = map.get(key2).size() - intersection;
                result += distinctOne * distinctTwo;
            }    
        }
        return result;
    }
}
