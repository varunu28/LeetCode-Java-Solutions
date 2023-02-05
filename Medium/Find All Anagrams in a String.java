class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int[] patternCounter = new int[26];
        for (char c : p.toCharArray()) {
            patternCounter[c - 'a']++;
        }
        int[] counter = new int[26];
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            if (i >= p.length() - 1) {
                if (Arrays.equals(patternCounter, counter)) {
                    result.add(start);
                }
                counter[s.charAt(start++) - 'a']--;
            }
        }
        return result;
    }
}
