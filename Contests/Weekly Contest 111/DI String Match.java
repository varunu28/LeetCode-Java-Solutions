class Solution {
    public int[] diStringMatch(String S) {
        int[] ans = new int[S.length() + 1];

        int iStart = 0;
        int dStart = S.length();

        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) == 'I') {
                ans[i] = iStart++;
            }
            else {
                ans[i] = dStart--;
            }
        }

        ans[ans.length - 1] = dStart == 0 ? iStart : dStart;

        return ans;
    }
}
