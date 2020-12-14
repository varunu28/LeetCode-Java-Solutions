class Solution {
  public int minPartitions(String n) {
    return n.chars()
            .mapToObj(c -> (char) c)
            .mapToInt(Character::getNumericValue)
            .reduce(Integer::max)
            .orElse(0);
  }
}
