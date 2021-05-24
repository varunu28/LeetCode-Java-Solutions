class Solution {
  public String toLowerCase(String s) {
    return s.chars().mapToObj(c -> (char) c).map(Character::toLowerCase).map(String::valueOf)
        .collect(Collectors.joining());
  }
}
