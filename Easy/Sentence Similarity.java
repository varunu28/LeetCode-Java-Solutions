class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        
        Map<String, HashSet<String>> map = new HashMap<>();
        
        for (String[] p: pairs) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        
        for (int i=0;i<words1.length;i++) {
            if (!((words1[i].equals(words2[i])) || (map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i])) ||
                 (map.containsKey(words2[i]) && map.get(words2[i]).contains(words1[i])))) {
                return false;
            }
        }
        
        return true;
    }
}
