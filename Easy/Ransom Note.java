class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> noteMap = new HashMap<>();
        Map<Character, Integer> magMap = new HashMap<>();
        
        for(char c: ransomNote.toCharArray()) {
            if (noteMap.containsKey(c)) {
                noteMap.put(c, noteMap.get(c) + 1);
            }
            else {
                noteMap.put(c, 1);
            }
        }
        
        for(char c: magazine.toCharArray()) {
            if (magMap.containsKey(c)) {
                magMap.put(c, magMap.get(c) + 1);
            }
            else {
                magMap.put(c, 1);
            }
        }
        
        for (Map.Entry<Character, Integer> entry: noteMap.entrySet()) {
            if (magMap.containsKey(entry.getKey()) && magMap.get(entry.getKey()) >= entry.getValue()) {
                continue;
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}
