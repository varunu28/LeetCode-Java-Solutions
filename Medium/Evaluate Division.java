class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, List<String>> map = new HashMap<>();
    Map<String, List<Double>> valueMap = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      List<String> equation = equations.get(i);
      map.computeIfAbsent(equation.get(0), k -> new ArrayList<>()).add(equation.get(1));
      map.computeIfAbsent(equation.get(1), k -> new ArrayList<>()).add(equation.get(0));
      valueMap.computeIfAbsent(equation.get(0), k -> new ArrayList<>()).add(values[i]);
      valueMap.computeIfAbsent(equation.get(1), k -> new ArrayList<>()).add(1 / values[i]);      
    }
    double[] ans = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      ans[i] = dfs(map, valueMap, query.get(0), query.get(1), new HashSet<>(), 1.0);
      ans[i] = ans[i] == 0.0 ? -1.0 : ans[i];
    }
    return ans;
  }
  
  private double dfs(Map<String, List<String>> map, Map<String, List<Double>> valueMap, String a, String b, Set<String> set, double curr) {
    if (set.contains(a)) {
      return 0.0;
    }
    if (!map.containsKey(a)) {
      return 0.0;
    }
    if (a.equals(b)) {
      return curr;
    }
    set.add(a);
    List<String> children = map.get(a);
    List<Double> valueList = valueMap.get(a);
    double temp = 0.0;
    for (int i = 0; i < children.size(); i++) {
      temp = dfs(map, valueMap, children.get(i), b, set, curr * valueList.get(i));
      if (temp != 0.0) {
        break;
      }
    }
    set.remove(a);
    return temp;
  }
}
