class Solution {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(keyboard.charAt(i), i);
        }
        int position = 0;
        int time = 0;
        for (char c : word.toCharArray()) {
            time += Math.abs(position - map.get(c));
            position = map.get(c);
        }
        return time;
    }
}
