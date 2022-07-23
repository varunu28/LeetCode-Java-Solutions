class Solution {
  public String bestHand(int[] ranks, char[] suits) {
    char suitCard = '-';
    for (int i = 0; i < suits.length; i++) {
      if (suitCard != '-' && suitCard != suits[i]) {
        break;
      }
      if (suitCard == '-') {
        suitCard = suits[i];
      }
      if (i == suits.length - 1) {
        return "Flush";
      }
    }
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    boolean pairFound = false;
    for (int rank : ranks) {
      frequencyMap.put(rank, frequencyMap.getOrDefault(rank, 0) + 1);
      if (frequencyMap.get(rank) == 3) {
        return "Three of a Kind";
      }
      if (frequencyMap.get(rank) == 2) {
        pairFound = true;
      }
    }
    return pairFound ? "Pair" : "High Card";
  }
}
