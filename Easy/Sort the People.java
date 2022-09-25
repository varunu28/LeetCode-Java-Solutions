class Solution {
  public String[] sortPeople(String[] names, int[] heights) {
    return IntStream.range(0, names.length)
        .boxed()
        .sorted((o1, o2) -> heights[o2] - heights[o1])
        .map(idx -> names[idx])
        .toList()
        .toArray(new String[0]);
  }
}
