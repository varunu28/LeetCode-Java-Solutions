class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        letterCasePermutationHelper(ans, S.toCharArray(), 0);

        return ans;
    }

    private void letterCasePermutationHelper(List<String> ans, char[] chars, int index) {
        if (index == chars.length) {
            ans.add(new String(chars));
        }
        else {
            if (Character.isLetter(chars[index])) {
                chars[index] = Character.toLowerCase(chars[index]);
                letterCasePermutationHelper(ans, chars, index+1);
                chars[index] = Character.toUpperCase(chars[index]);
            }

            letterCasePermutationHelper(ans, chars, index+1);
        }
    }
}
