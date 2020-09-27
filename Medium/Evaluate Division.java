class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values,
      List<List<String>> queries) {
    double[] ans = new double[queries.size()];
    Map<String, Set<String>> connectionMap = new HashMap<>();
    Map<String, Double> valueMap = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      String equation = equations.get(i).get(0) + "/" + equations.get(i).get(1);
      connectionMap.computeIfAbsent(equations.get(i).get(0), k -> new HashSet<>())
          .add(equations.get(i).get(1));
      connectionMap.computeIfAbsent(equations.get(i).get(1), k -> new HashSet<>())
          .add(equations.get(i).get(0));
      valueMap.put(equation, values[i]);
    }
    for (int i = 0; i < queries.size(); i++) {
      String source = queries.get(i).get(0);
      String target = queries.get(i).get(1);
      double[] res = {-1.0};
      dfs(connectionMap, valueMap, source, target, new HashSet<>(), res, 1.0);
      ans[i] = res[0];
    }
    return ans;
  }

  private void dfs(Map<String, Set<String>> connectionMap, Map<String, Double> valueMap,
      String source, String target, Set<String> visited, double[] res, double currVal) {
    if (source.equals(target) && (
        connectionMap.containsKey(source) || connectionMap.containsKey(target))
    ) {
      res[0] = currVal;
      return;
    }
    for (String connection : connectionMap.getOrDefault(source, new HashSet<>())) {
      if (!visited.contains(connection)) {
        visited.add(connection);
        double newwCurrVal = currVal * (
            valueMap.containsKey(source + "/" + connection) ?
                valueMap.get(source + "/" + connection) :
                (1 / valueMap.get(connection + "/" + source))
        );
        dfs(connectionMap, valueMap, connection, target, visited, res, newwCurrVal);
      }
    }
  }
}
