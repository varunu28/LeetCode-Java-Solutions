class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        if (words.length == 0) {
            return indexes;
        }
        
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        
        int start = 0;
        int oneWordLen = words[0].length();
        int totalLen = oneWordLen * words.length;
        
        while ((s.length() - start) >= totalLen) {
            String subStr = s.substring(start, start + totalLen);
            int i = 0;
            Map<String, Integer> map = new HashMap<>(freqMap);
            while (i < subStr.length()) {
                String wordStr = subStr.substring(i, i + oneWordLen);
                
                if (!map.containsKey(wordStr) || map.get(wordStr) < 1) {
                    break;
                }
                
                map.put(wordStr, map.get(wordStr) - 1);
                i += oneWordLen;
            }
            
            if (i >= subStr.length()) {
                indexes.add(start);
            }
            
            start++;
        }
        
        return indexes;
    }
}
