class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int n = num.length();
        
        while (idx < n) {
            while (k > 0 && !stack.isEmpty()) {
                if (stack.peek() > Character.getNumericValue(num.charAt(idx))) {
                    stack.pop();
                    k--;
                }
                else {
                    break;
                }
            }
            
            stack.push(Character.getNumericValue(num.charAt(idx)));
            idx++;
        }
        
        while (k-- > 0) {
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        int zeroIndex = -1;
        for (int i = sb.length() - 1; i>=0; i--) {
            if (sb.charAt(i) == '0') {
                zeroIndex++;
            }
            else {
                break;
            }
        }
        
        String ans = sb.reverse().toString().substring(zeroIndex + 1);
        
        return ans.length() == 0 ? "0" : ans;
    }                    
}
