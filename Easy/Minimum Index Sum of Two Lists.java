class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      map.put(list1[i], i);
    }
    List<String> list = new ArrayList<>();
    int minIndexSum = Integer.MAX_VALUE;
    for (int i = 0; i < list2.length; i++) {
      if (map.containsKey(list2[i])) {
        int indexSum = map.get(list2[i]) + i;
        if (indexSum < minIndexSum) {
          minIndexSum = indexSum;
          list = new ArrayList<>();
          list.add(list2[i]);
        }
        else if (indexSum == minIndexSum) {
          list.add(list2[i]);
        }
      }
    }
    String[] ans = new String[list.size()];
    for (int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }
    return ans;
  }
}
