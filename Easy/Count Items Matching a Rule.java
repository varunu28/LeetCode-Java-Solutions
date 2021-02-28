class Solution {
  public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    int ruleIdx = ruleKey.equals("type") ? 0 : (ruleKey.equals("color") ? 1 : 2);
    return (int) items.stream().filter(item -> item.get(ruleIdx).equals(ruleValue)).count();
  }
}
