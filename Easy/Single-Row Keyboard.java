class Solution {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }
        
        int currPos = 0;
        int totalTime = 0;
        for (char c : word.toCharArray()) {
            totalTime += Math.abs(currPos - map.get(c));
            currPos = map.get(c);
        }
        
        return totalTime;
    }
}
