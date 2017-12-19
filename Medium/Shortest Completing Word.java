class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        String licenseWords = "";
        for (int i=0; i<licensePlate.length(); i++) {
            if (Character.isLetter(licensePlate.charAt(i))) {
                licenseWords = licenseWords + String.valueOf(licensePlate.charAt(i));
            }
        }
        
        String ans = "";
        int l = Integer.MAX_VALUE;
        
        for (String word : words) {
            if (complete(word.toLowerCase(), licenseWords.toLowerCase())) {
                if (word.length() < l) {
                    l = word.length();
                    ans = word;
                }
            }
        }
        
        return ans;
    }
    
    private boolean complete(String word, String toCheck) {
        
        Map<Character, Integer> wordMap = new HashMap<>();
        Map<Character, Integer> toCheckMap = new HashMap<>();
        
        for (int i=0;i<word.length(); i++) {
            wordMap.put(word.charAt(i), wordMap.getOrDefault(word.charAt(i), 0) + 1);
        }
        
        for (int i=0;i<toCheck.length(); i++) {
            toCheckMap.put(toCheck.charAt(i), toCheckMap.getOrDefault(toCheck.charAt(i), 0) + 1);
        }
        
        for(Map.Entry<Character, Integer> entry : toCheckMap.entrySet()) {
            if (wordMap.containsKey(entry.getKey()) && wordMap.get(entry.getKey()) >= entry.getValue()) {
                continue;
            }
            
            return false;
        }
        
        return true;
    }
}
