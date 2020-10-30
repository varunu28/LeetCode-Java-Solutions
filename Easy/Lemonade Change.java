class Solution {
  public boolean lemonadeChange(int[] bills) {
    final int LEMONADE_COST = 5;
    int[] billDenominations = {20, 10, 5};
    Map<Integer, Integer> cashCounter = new HashMap<>();
    for (int bill : bills) {
      int changeRequired = bill - LEMONADE_COST;
      cashCounter.put(bill, cashCounter.getOrDefault(bill, 0) + 1);
      for (Integer denomination : billDenominations) {
        int numOfBills = Math.min(
            changeRequired / denomination, cashCounter.getOrDefault(denomination, 0)
        );
        changeRequired -= denomination * numOfBills;
        cashCounter.put(
          denomination, cashCounter.getOrDefault(denomination, 0) - numOfBills
        );
      }
      if (changeRequired > 0) {
        return false;
      }
    }
    return true;
  }
}
