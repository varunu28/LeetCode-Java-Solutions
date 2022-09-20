class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      map.put(list1[i], i);
    }
    int minIndexSum = Integer.MAX_VALUE;
    Map<String, Integer> stringToIndexSum = new HashMap<>();
    for (int i = 0; i < list2.length; i++) {
      if (map.containsKey(list2[i])) {
        int indexSum = i + map.get(list2[i]);
        minIndexSum = Math.min(minIndexSum, indexSum);
        stringToIndexSum.put(list2[i], indexSum);
      }
    }
    List<String> result = new ArrayList<>();
    for (String key : stringToIndexSum.keySet()) {
      if (stringToIndexSum.get(key) == minIndexSum) {
        result.add(key);
      }
    }
    String[] resultArr = new String[result.size()];
    for (int i = 0; i < result.size(); i++) {
      resultArr[i] = result.get(i);
    }
    return resultArr;
  }
}
