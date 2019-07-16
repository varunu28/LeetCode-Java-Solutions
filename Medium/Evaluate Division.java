class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];

        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Double> resMap = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String operand1 = equations.get(i).get(0);
            String operand2 = equations.get(i).get(1);

            map.computeIfAbsent(operand1, k -> new HashSet<>()).add(operand2);
            map.computeIfAbsent(operand2, k -> new HashSet<>()).add(operand1);

            resMap.put(operand1 + "|" + operand2, values[i]);
        }

        for (int i = 0; i < queries.size(); i++) {
            String operand1 = queries.get(i).get(0);
            String operand2 = queries.get(i).get(1);

            if (!map.containsKey(operand1) || !map.containsKey(operand2)) {
                ans[i] = -1.0;
            }
            else if (operand1.equals(operand2)) {
                ans[i] = 1.0;
            }
            else if (map.get(operand1).contains(operand2)) {
                ans[i] = getSimpleDivisionVal(resMap, operand1, operand2);
            }
            else if (operand2.contains(operand1)) {
                ans[i] = getSimpleDivisionVal(resMap, operand2, operand1);
            }
            else {
                ans[i] = dfs(map, resMap, operand1, operand2, 1.0, new HashSet<>());
            }
        }

        return ans;
    }

    private double dfs (Map<String, Set<String>> map, Map<String, Double> resMap, String operand1, String operand2,
                        double base, Set<String> visited) {
        if (visited.contains(operand1)) {
            return -1.0;
        }
        if (map.get(operand1).contains(operand2)) {
            return base * getSimpleDivisionVal(resMap, operand1, operand2);
        }

        visited.add(operand1);

        double ans = -1.0;
        Iterator<String> children = map.get(operand1).iterator();

        while (children.hasNext()) {
            String child = children.next();
            if (!visited.contains(child)) {
                ans = Math.max(ans, dfs(map, resMap, child, operand2, base * getSimpleDivisionVal(resMap, operand1, child), visited));
            }
        }

        return ans;
    }

    private double getSimpleDivisionVal (Map<String, Double> resMap, String operand1, String operand2) {
        if (resMap.containsKey(operand1 + "|" + operand2)) {
            return resMap.get(operand1 + "|" + operand2);
        }

        return 1 / resMap.get(operand2 + "|" + operand1);
    }
}
