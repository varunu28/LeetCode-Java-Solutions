class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, Integer> patternMap = new HashMap<>();
        StringBuilder patternCode = new StringBuilder();
        int maxVal = 1;
        
        for (char c : pattern.toCharArray()) {
            if (patternMap.containsKey(c)) {
                patternCode.append(patternMap.get(c));
            }
            else {
                patternMap.put(c, maxVal++);
                patternCode.append(patternMap.get(c));
            }
        }
        
        Map<String, Integer> strMap = new HashMap<>();
        StringBuilder strCode = new StringBuilder();
        maxVal = 1;
        
        for (String s : str.trim().split("\\s+")) {
            if (strMap.containsKey(s)) {
                strCode.append(strMap.get(s));
            }
            else {
                strMap.put(s, maxVal++);
                strCode.append(strMap.get(s));
            }
        }
        
        return patternCode.toString().equals(strCode.toString());
    }
}
