class Solution {
  public List<Integer> countSmaller(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    int[] indices = new int[n];
    for (int i = 0; i < n; i++) {
      indices[i] = i;
    }
    mergesort(indices, 0, n, result, nums);
    return Arrays.stream(result).boxed().collect(Collectors.toList());
  }
  
  private void mergesort(int[] indices, int left, int right, int[] result, int[] nums) {
    if (right - left <= 1) {
      return;
    }
    int mid = (left + right) / 2;
    mergesort(indices, left, mid, result, nums);
    mergesort(indices, mid, right, result, nums);
    merge(indices, left, right, mid, result, nums);
  }
  
  private void merge(int[] indices, int left, int right, int mid, int[] result, int[] nums) {
    int i = left;
    int j = mid;
    List<Integer> temp = new ArrayList<>();
    while (i < mid && j < right) {
      if (nums[indices[i]] <= nums[indices[j]]) {
        result[indices[i]] += j - mid;
        temp.add(indices[i]);
        i++;
      } else {
        temp.add(indices[j]);
        j++;
      }
    }
    while (i < mid) {
      result[indices[i]] += j - mid;
      temp.add(indices[i]);
      i++;
    }
    while (j < right) {
      temp.add(indices[j]);
      j++;
    }
    for (int k = left; k < right; k++) {
      indices[k] = temp.get(k - left);
    }
  }
}
