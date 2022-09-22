class Solution {
  public boolean lemonadeChange(int[] bills) {
    int[] billCount = new int[3];
    for (int bill : bills) {
      int returnAmount = bill - 5;
      for (int i = 2; i >= 0 && returnAmount > 0; i--) {
        int amount = i == 2 ? 20 : (i == 1 ? 10 : 5);
        if (returnAmount >= amount) {
          int billsRequired = returnAmount / amount;
          int billsAvailable = billCount[i];
          returnAmount -= Math.min(billsRequired, billsAvailable) * amount;
          billCount[i] -= Math.min(billsRequired, billsAvailable);
        }
      }
      if (returnAmount != 0) {
        return false;
      }
      int amountIdx = bill == 20 ? 2 : (bill == 10 ? 1 : 0);
      billCount[amountIdx]++;
    }
    return true;
  }
}
