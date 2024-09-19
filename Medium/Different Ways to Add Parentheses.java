class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        if (expression.length() == 0) {
            return result;
        }
        if (expression.length() == 1) {
            result.add(Integer.parseInt(expression));
            return result;
        }
        if (expression.length() == 2 && Character.isDigit(expression.charAt(0))) {
            result.add(Integer.parseInt(expression));
            return result;
        }
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                continue;
            }
            List<Integer> leftResult = diffWaysToCompute(expression.substring(0, i));
            List<Integer> rightResult = diffWaysToCompute(expression.substring(i + 1));
            for (int leftVal : leftResult) {
                for (int rightVal : rightResult) {
                    int value = 0;
                    switch(c) {
                        case '+':
                            value = leftVal + rightVal;
                            break;
                        case '-':
                            value = leftVal - rightVal;
                            break;
                        case '*':
                            value = leftVal * rightVal;
                            break;
                    }
                    result.add(value);
                }
            }
        }
        return result;
    }
}
