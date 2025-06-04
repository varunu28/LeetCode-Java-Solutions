class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String result = "";
        for (int i = 0; i < n; i++) {
            String curr = word.substring(i, Math.min(i + n - numFriends + 1, n));
            if (result.compareTo(curr) <= 0) {
                result = curr;
            }
        }
        return result;
    }
}
