class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!inOrder(words[i], words[i + 1], map)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean inOrder(String wordOne, String wordTwo, Map<Character, Integer> map) {
        for (int i = 0; i < Math.min(wordOne.length(), wordTwo.length()); i++) {
            int diff = map.get(wordOne.charAt(i)) - map.get(wordTwo.charAt(i));
            if (diff < 0) {
                return true;
            }
            if (diff > 0) {
                return false;
            }
        }
        return wordOne.length() <= wordTwo.length();
    }
}
