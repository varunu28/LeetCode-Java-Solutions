class Solution {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>(){
      public int compare(int[] o1, int[] o2) {
        int c = o2[0] - o1[0];
        if (c != 0) {
          return c;
        }
        return o1[1] - o2[1]; 
      }
    });
    System.out.println();
    List<int[]> list = new ArrayList<>();
    for (int[] p : people) {
      list.add(p[1], p);
    }
    int n = people.length;
    return list.toArray(new int[n][2]);
  }
}
