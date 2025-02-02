class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (Character key : map.keySet()) {
            Integer value = map.get(key);
            if (value % 2 == 0) {
                minEven = Math.min(minEven, value);
            } else {
                maxOdd = Math.max(maxOdd, value);
            }
        }
        return maxOdd - minEven;
    }
}
