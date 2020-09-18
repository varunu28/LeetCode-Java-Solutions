class Solution {
  public int[] kWeakestRows(int[][] mat, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < mat.length; i++) {
      map.put(i, getLastIndex(mat[i], 0, mat[i].length - 1) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
      public int compare(Integer o1, Integer o2) {
        int c = map.get(o1) - map.get(o2);
        if (c != 0) {
          return c;
        }
        return o1 - o2;
      }
    });
    for (int i = 0; i < mat.length; i++) {
      pq.add(i);
    }
    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = pq.poll();
    }
    return ans;
  }
  
  private int getLastIndex(int[] arr, int start, int end) {
    int idx = -1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] == 1) {
        idx = Math.max(idx, mid);
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }
    return idx;
  }
}
