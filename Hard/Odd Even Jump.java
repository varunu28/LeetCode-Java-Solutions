class Solution {
  public int oddEvenJumps(int[] A) {
    int n = A.length;
    if (n <= 1) {
      return n;
    }
    boolean[] odd = new boolean[n];
    boolean[] even = new boolean[n];
    odd[n - 1] = even[n - 1] = true;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    map.put(A[n - 1], n - 1);
    int count = 0;
    for (int i = n - 2; i >= 0; i--) {
      int val = A[i];
      if (map.containsKey(val)) {
        odd[i] = even[map.get(val)];
        even[i] = odd[map.get(val)];
      }
      else {
        Integer lower = map.lowerKey(val);
        Integer higher = map.higherKey(val);
        if (lower != null) {
          even[i] = odd[map.get(lower)];
        }
        if (higher != null) {
          odd[i] = even[map.get(higher)];
        }
      }
      map.put(val, i);
    }
    for (boolean b : odd) {
      count += b ? 1 : 0;
    }
    return count;
  }
}
