class Solution {
    public boolean parseBoolExpr(String expression) {
        char[] chars = expression.toCharArray();
        Stack<Character> operations = new Stack<>();
        Stack<Character> boolValues = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '!' || c == '&' || c == '|') {
                operations.push(c);
            }
            else if (c == '(') {
                boolValues.push('#');
            }
            else if (c == 't' || c == 'f') {
                boolValues.push(chars[i]);
            }
            else if (c == ',') {
                continue;
            }
            else {
                List<Character> list = new ArrayList<>();
                while (!boolValues.isEmpty()) {
                    char temp = boolValues.pop();
                    if (temp == '#') {
                        break;
                    }

                    list.add(temp);
                }
                
                boolValues.push(performOperation(list, operations.pop()));
            }
        }

        return boolValues.peek() == 't' ? true : false;
    }

    private Character performOperation(List<Character> list, Character operation) {
        if (operation == '|') {
            return performOr(list);
        }
        else if (operation == '&') {
            return performAnd(list);
        }
        else {
            return list.get(0) == 't' ? 'f' : 't';
        }
    }

    private Character performAnd(List<Character> list) {
        boolean val = getBooleanValue(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            val &= getBooleanValue(list.get(i));
        }

        return val ? 't' : 'f';
    }

    private Character performOr(List<Character> list) {
        boolean val = getBooleanValue(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            val |= getBooleanValue(list.get(i));
        }

        return val ? 't' : 'f';
    }

    private boolean getBooleanValue(Character character) {
        return character == 't' ? true : false;
    }
}
