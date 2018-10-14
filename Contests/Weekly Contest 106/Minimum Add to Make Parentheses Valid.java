class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> open = new Stack<>();
        int count = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                open.push(c);
            }
            else {
                if (open.empty()) {
                    count++;
                }
                else {
                    open.pop();
                }
            }
        }

        count += open.size();

        return count;
    }
}
