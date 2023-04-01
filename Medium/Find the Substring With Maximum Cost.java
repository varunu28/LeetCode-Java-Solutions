class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            valueMap.put(chars.charAt(i), vals[i]);
        }
        int maxCost = 0;
        int currCost = 0;
        for (char c : s.toCharArray()) {
            int currCharCost = valueMap.containsKey(c) ? valueMap.get(c) : (c - 'a' + 1);
            currCost = Math.max(currCharCost, currCost + currCharCost);
            maxCost = Math.max(currCost, maxCost);
        }
        return maxCost;
    }
}
