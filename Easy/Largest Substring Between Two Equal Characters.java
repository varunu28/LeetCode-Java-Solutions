class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - map.get(s.charAt(i)) - 1);
        }
        return maxLength;
    }
}
