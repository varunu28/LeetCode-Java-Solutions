class Solution {
    public Map<Character, Character> map = new HashMap<Character, Character>(){{
        put('{', '}');
        put('[', ']');
        put('(', ')');
    }};

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char removed = stack.pop();
                if (map.get(removed) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
