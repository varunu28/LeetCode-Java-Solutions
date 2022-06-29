class Solution {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
    List<int[]> result = new ArrayList<>();
    for (int[] p : people) {
      result.add(p[1], p);
    }
    int n = people.length;
    return result.toArray(new int[n][2]);
  }
}
