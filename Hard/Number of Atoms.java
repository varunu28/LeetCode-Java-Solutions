class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        int idx = 0;
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        while (idx < n) {
            if (formula.charAt(idx) == '(') {
                stack.push(new HashMap<>());
                idx++;
            } else if (formula.charAt(idx) == ')') {
                Map<String, Integer> pop = stack.pop();
                int count = 0;
                idx++;
                while (idx < n && Character.isDigit(formula.charAt(idx))) {
                    count = count * 10 + (formula.charAt(idx) - '0');
                    idx++;
                }
                count = count == 0 ? 1 : count;
                Map<String, Integer> top = stack.peek();
                for (String key : pop.keySet()) {
                    int v = pop.get(key);
                    top.put(key, top.getOrDefault(key, 0) + v * count);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(formula.charAt(idx));
                idx++;
                while (idx < n && Character.isLowerCase(formula.charAt(idx))) {
                    sb.append(formula.charAt(idx++));
                }
                int count = 0;
                while (idx < n && Character.isDigit(formula.charAt(idx))) {
                    count = count * 10 + (formula.charAt(idx) - '0');
                    idx++;
                }
                count = count == 0 ? 1 : count;
                String atom = sb.toString();
                Map<String, Integer> top = stack.peek();
                top.put(atom, top.getOrDefault(atom, 0) + count);
            }
        }
        Map<String, Integer> finalMap = stack.pop();
        List<String> atoms = new ArrayList<>(finalMap.keySet());
        Collections.sort(atoms);
        StringBuilder result = new StringBuilder();
        for (String atom : atoms) {
            result.append(atom);
            int count = finalMap.get(atom);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }
}
