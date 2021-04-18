class Solution {
  public boolean checkIfPangram(String sentence) {
    return sentence.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size() == 26;
  }
}
