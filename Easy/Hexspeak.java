class Solution {
    Integer[] keys = {0, 1, 10, 11, 12, 13, 14, 15};
    String[] values = {"O", "I", "A", "B", "C", "D", "E", "F"};
    Map<Long, String> map;
    public String toHexspeak(String num) {
        map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.put((long) keys[i], values[i]);
        }
        StringBuilder sb = new StringBuilder();
        Long n = Long.parseLong(num);
        while (n > 0) {
            Long quot = n % 16;
            n /= 16;
            if (map.containsKey(quot)) {
                sb.append(map.get(quot));
            }
            else {
                return "ERROR";
            }
        }
        return sb.reverse().toString();
    }
}
