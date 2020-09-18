class Solution {
  public List<List<String>> displayTable(List<List<String>> orders) {
    Map<Integer, Map<String, Integer>> map = new HashMap<>();
    Set<Integer> tablesOrdered = new TreeSet<>();
    Set<String> possibleItems = new TreeSet<>();
    for (List<String> order : orders) {
      int tableId = Integer.parseInt(order.get(1));
      for (int i = 2; i < order.size(); i++) {
        map.computeIfAbsent(tableId, k -> new HashMap<>());
        Map<String, Integer> tableMap = map.get(tableId);
        tableMap.put(order.get(i), tableMap.getOrDefault(order.get(i), 0) + 1);
        possibleItems.add(order.get(i));
      }
      tablesOrdered.add(tableId);
    }
    List<List<String>> list = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    temp.add("Table");
    temp.addAll(possibleItems);
    list.add(temp);
    temp = new ArrayList<>();
    for (Integer table : tablesOrdered) {
      Map<String, Integer> tableMap = map.get(table);
      temp.add(String.valueOf(table));
      for (String item : possibleItems) {
        temp.add(String.valueOf(tableMap.getOrDefault(item, 0)));
      }
      list.add(temp);
      temp = new ArrayList<>();
    }
    return list;
  }
}
