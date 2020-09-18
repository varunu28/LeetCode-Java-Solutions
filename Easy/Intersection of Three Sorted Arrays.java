class Solution {
  public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
    int[] counter = new int[2001];
    updateCounter(counter, arr1);
    updateCounter(counter, arr2);
    updateCounter(counter, arr3);
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < 2001; i++) {
      if (counter[i] == 3) {
        ans.add(i);
      }
    }
    return ans;
  }
  
  private void updateCounter(int[] counter, int[] arr) {
    for (int num : arr) {
      counter[num]++;
    }
  }
}
