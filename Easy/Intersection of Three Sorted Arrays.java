class Solution {
  public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
    int idxOne = 0;
    int idxTwo = 0;
    int idxThree = 0;
    List<Integer> result = new ArrayList<>();
    while (idxOne < arr1.length && idxTwo < arr2.length && idxThree < arr3.length) {
      if (arr1[idxOne] == arr2[idxTwo] && arr2[idxTwo] == arr3[idxThree]) {
        result.add(arr1[idxOne]);
        idxOne++;
        idxTwo++;
        idxThree++;
      } else {
        int max = Math.max(arr1[idxOne], Math.max(arr2[idxTwo], arr3[idxThree]));
        if (arr1[idxOne] < max) {
          idxOne++;
        }
        if (arr2[idxTwo] < max) {
          idxTwo++;
        }
        if (arr3[idxThree] < max) {
          idxThree++;
        }
      }
    }
    return result;
  }
}
