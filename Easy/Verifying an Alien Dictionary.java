class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i=0; i<order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        
        String prev = null;
        
        for (String word : words) {
            if (prev == null) {
                prev = word;
                continue;
            }
            
            for (int i=0; i<Math.min(prev.length(), word.length()); i++) {
                if (orderMap.get(word.charAt(i)) > orderMap.get(prev.charAt(i))) {
                    break;
                }
                else if (orderMap.get(word.charAt(i)) < orderMap.get(prev.charAt(i))) {
                    return false;
                } 
                else if (word.length() != prev.length() && i == word.length() - 1) {
                    return false;
                }
            }
            
            prev = word;
        }
        
        return true;
    }
}
