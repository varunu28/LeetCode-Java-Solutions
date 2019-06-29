class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int count = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < K - 1 && i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }

        for (int i = K - 1; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
            if (map.size() == K) {
                count++;
            }

            map.put(S.charAt(start), map.get(S.charAt(start)) - 1);
            if (map.get(S.charAt(start)) == 0) {
                map.remove(S.charAt(start));
            }

            start++;
        }

        return count;
    }
}
