class Solution {
    public int clumsy(int N) {
        if (N <= 1) {
            return N;
        }

        char[] oper = {'*', '/', '+', '-'};
        int idx = 0;

        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            sb.append(N).append(" ").append(oper[idx++]).append(" ");
            if (idx > 3) {
                idx = 0;
            }

            N--;
        }

        return basicCalculator(sb.toString().substring(0, sb.length() - 2));
    }

    private int basicCalculator(String s) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + Character.getNumericValue(s.charAt(i));
            }

            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                else if (sign == '-') {
                    stack.push(-num);
                }
                else if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                else {
                    stack.push(stack.pop() / num);
                }

                sign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
