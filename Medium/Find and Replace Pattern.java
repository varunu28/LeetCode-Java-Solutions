class Solution {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        String givenPattern = getStringPattern(pattern);
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            if (getStringPattern(word).equals(givenPattern)) {
                ans.add(word);
            }
        }

        return ans;
    }

    private static String getStringPattern(String pattern) {
        StringBuilder sb = new StringBuilder();
        char[] chars = pattern.toCharArray();
        int val = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : chars) {
            if (!map.containsKey(c)) {
                map.put(c, val);
                val++;
            }
        }

        for (int i=0; i<chars.length; i++) {
            sb.append(map.get(chars[i]));
        }

        return sb.toString();
    }
}
