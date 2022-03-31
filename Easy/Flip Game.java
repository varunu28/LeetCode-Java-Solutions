class Solution {
  public List<String> generatePossibleNextMoves(String currentState) {
    List<String> list = new ArrayList<>();
    for (int i = 1; i < currentState.length(); i++) {
      if (currentState.charAt(i) == '+' && currentState.charAt(i - 1) == '+') {
        list.add(currentState.substring(0, i - 1) + "--" + currentState.substring(i + 1));
      }
    }
    return list;
  }
}
