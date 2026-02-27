class Solution {

    private static final Map<String, Integer> ROMAN_TO_INT = Map.ofEntries(
        Map.entry("I", 1),
        Map.entry("IV", 4),
        Map.entry("V", 5),
        Map.entry("IX", 9),
        Map.entry("X", 10),
        Map.entry("XL", 40),
        Map.entry("L", 50),
        Map.entry("XC", 90),
        Map.entry("C", 100),
        Map.entry("CD", 400),
        Map.entry("D", 500),
        Map.entry("CM", 900),
        Map.entry("M", 1000)
    );

    public int romanToInt(String s) {
        int idx = 0;
        int result = 0;
        int n = s.length();
        while (idx < n) {
            if (idx + 1 < n && ROMAN_TO_INT.containsKey(s.substring(idx, idx + 2))) {
                result += ROMAN_TO_INT.get(s.substring(idx, idx + 2));
                idx += 2;
            } else {
                result += ROMAN_TO_INT.get(s.substring(idx, idx + 1));
                idx++;
            }
        }
        return result;
    }
}
