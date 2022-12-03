class Solution {
    
    private static final String ALL_LETTERS = 
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(c));
        }
        List<Character>[] frequencyToChar = new List[maxFrequency + 1];
        for (char c : map.keySet()) {
            if (frequencyToChar[map.get(c)] == null) {
                frequencyToChar[map.get(c)] = new ArrayList<>();
            }
            frequencyToChar[map.get(c)].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxFrequency; i > 0; i--) {
            List<Character> characters = frequencyToChar[i] == null ? 
                new ArrayList<>() : frequencyToChar[i];
            for (char c : characters) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
