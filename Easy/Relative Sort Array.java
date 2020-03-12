class Solution {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr2.length; i++) {
      map.put(arr2[i], i);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
      public int compare(Integer o1, Integer o2) {
        return map.get(o1) - map.get(o2);
      }
    });
    List<Integer> notPresent = new ArrayList<>();
    for (int num : arr1) {
      if (map.containsKey(num)) {
        pq.add(num);
      }
      else {
        notPresent.add(num);
      }
    }
    int[] ans = new int[arr1.length];
    int idx = 0;
    while (!pq.isEmpty()) {
      ans[idx++] = pq.poll();
    }
    Collections.sort(notPresent);
    for (int num : notPresent) {
      ans[idx++] = num;
    }
    return ans;
  }
}
