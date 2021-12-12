class Solution {
  public int countPoints(String rings) {
    Map<Integer, Set<Character>> map = new HashMap<>();
    for (int i = 0; i < rings.length(); i += 2) {
      char ring = rings.charAt(i);
      int rod = Character.getNumericValue(rings.charAt(i + 1));
      map.computeIfAbsent(rod, k -> new HashSet()).add(ring);
    }
    return (int) map.values().stream().filter(v -> v.size() == 3).count();
  }
}
