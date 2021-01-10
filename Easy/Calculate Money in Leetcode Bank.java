class Solution {
  public int totalMoney(int n) {
    int totalAmount = 0;
    int mondayMoney = 1;
    while (n > 0) {
      totalAmount += mondayMoney++;
      n--;
      int daysInWeek = Math.min(6, n);
      totalAmount += getCummulativeSum(mondayMoney, daysInWeek);
      n -= daysInWeek;
    }
    return totalAmount;
  }
  
  private int getCummulativeSum(int firstTerm, int n) {
    if (n <= 0) {
      return 0;
    }
    return ((2 * firstTerm + (n - 1)) * n) / 2;
  }
}
