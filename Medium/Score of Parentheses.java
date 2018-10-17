class Solution {
    public static int scoreOfParentheses(String S) {
        Stack<String> st = new Stack<>();
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) == '(') {
                st.push(String.valueOf(S.charAt(i)));
            }
            else {
                int num = 0;
                while (!st.peek().equals("(")) {
                    num += Integer.parseInt(st.pop());
                }
                st.pop();
                st.push(num == 0 ? String.valueOf("1") : String.valueOf(2*num));
            }
        }

        int ans = 0;
        while (!st.empty()) {
            ans += Integer.parseInt(st.pop());
        }

        return ans;
    }
}
