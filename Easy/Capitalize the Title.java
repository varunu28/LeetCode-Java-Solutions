class Solution {
  public String capitalizeTitle(String title) {
    return Arrays.stream(title.split("\\s+"))
        .map(e -> e.length() <= 2 ? e.toLowerCase() :
            e.substring(0, 1).toUpperCase() + e.substring(1).toLowerCase())
        .collect(Collectors.joining(" "));
  }
}
