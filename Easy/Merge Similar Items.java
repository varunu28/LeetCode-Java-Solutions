class Solution {
  public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] item : items1) {
      map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
    }
    for (int[] item : items2) {
      map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
    }
    List<List<Integer>> result = new ArrayList<>();
    for (Integer key : map.keySet()) {
      result.add(Arrays.asList(key, map.get(key)));
    }
    Collections.sort(result, Comparator.comparing(o -> o.get(0)));
    return result;
  }
}
