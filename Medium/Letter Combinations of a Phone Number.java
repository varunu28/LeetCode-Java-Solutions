class Solution {
    private static final Map<Character, String> DIGIT_TO_CHAR_MAPPING = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        letterCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void letterCombinations(String digits, int idx, StringBuilder sb, List<String> result) {
        if (idx == digits.length()) {
            if (!sb.isEmpty()) {
                result.add(sb.toString());
            }
            return;
        }
        for (char c : DIGIT_TO_CHAR_MAPPING.get(digits.charAt(idx)).toCharArray()) {
            sb.append(c);
            letterCombinations(digits, idx + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
