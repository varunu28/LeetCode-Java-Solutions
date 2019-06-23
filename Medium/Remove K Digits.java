class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int n = num.length();
        while (idx < n) {
            while (k > 0 && !stack.isEmpty()) {
                if (stack.peek() <= Character.getNumericValue(num.charAt(idx))) {
                    break;
                }
                stack.pop();
                k--;
            }
            
            stack.push(Character.getNumericValue(num.charAt(idx++)));
        }
        
        while (k-- > 0) {
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        String ans = sb.reverse().toString();
        idx = -1;
        while (idx + 1 < ans.length() && ans.charAt(idx + 1) == '0') {
            idx++;
        }
        
        return ans.substring(idx + 1).length() == 0 ? "0" : ans.substring(idx + 1);
    }
}
