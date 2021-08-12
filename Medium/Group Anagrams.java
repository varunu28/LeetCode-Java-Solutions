class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    return new ArrayList<>(
        Arrays.stream(strs).collect(Collectors.groupingBy(Solution::getCodedString)).values());
  }

  public static String getCodedString(String s) {
    return s.chars()
        .mapToObj(c -> (char) c)
        .sorted()
        .map(Object::toString)
        .collect(Collectors.joining());
  }
}
