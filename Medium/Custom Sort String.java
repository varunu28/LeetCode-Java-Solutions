class Solution {
  public String customSortString(String order, String s) {
    Map<Character, Integer> map = new HashMap<>();
    int position = 1;
    for (char c : order.toCharArray()) {
      map.put(c, position++);
    }
    return s.chars()
        .mapToObj(c -> (char) c)
        .sorted(Comparator.comparing(o -> map.getOrDefault(o, 0)))
        .collect(Collector.of(StringBuilder::new,
          StringBuilder::append,
          StringBuilder::append,
          StringBuilder::toString));
  }
}
