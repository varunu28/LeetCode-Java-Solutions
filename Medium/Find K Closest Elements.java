class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    if (k == 0 || arr.length == 0) {
      return new ArrayList<>();
    }
    int[] diffArr = new int[arr.length];
    int minDiff = Integer.MAX_VALUE;
    int minDiffIdx = -1;
    for (int i = 0; i < arr.length; i++) {
      diffArr[i] = Math.abs(arr[i] - x);
      if (minDiff > diffArr[i]) {
        minDiff = diffArr[i];
        minDiffIdx = i;
      }
    }
    int left = minDiffIdx - 1;
    int right = minDiffIdx + 1;
    List<Integer> list = new ArrayList<>();
    list.add(arr[minDiffIdx]);
    k--;
    while (k > 0) {
      if (left >= 0 && right < arr.length) {
        if (diffArr[left] <= diffArr[right]) {
          list.add(arr[left--]);
        }
        else {
          list.add(arr[right++]);
        }
      }
      else if (left >= 0 && right == arr.length) {
        list.add(arr[left--]);
      }
      else {
        list.add(arr[right++]);
      }
      k--;
    }
    Collections.sort(list);
    return list;
  }
}
