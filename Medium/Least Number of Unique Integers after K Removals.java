class Solution {
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    for (int num : arr) {
      if (!map.containsKey(num)) {
        list.add(num);
      }
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    Collections.sort(list, new Comparator<Integer>(){
      public int compare(Integer o1, Integer o2) {
        return map.get(o1) - map.get(o2);
      }
    });
    for (Integer num : list) {
      int count = map.get(num);
      k -= count;
      if (k >= 0) {
        map.remove(num);
      }
      else {
       break; 
      }
    }
    return map.size();
  }
}
