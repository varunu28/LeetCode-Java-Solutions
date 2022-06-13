class Solution {
  public double calculateTax(int[][] brackets, int income) {
    if (income == 0) {
      return 0.0;
    }
    double tax = 0.0;
    int idx = 0;
    while (idx < brackets.length) {
      int[] currentBracket = brackets[idx];
      int amount = idx > 0 ? (Math.min(currentBracket[0], income)) - brackets[idx - 1][0] : Math.min(currentBracket[0], income);
      double taxPercentage = ((double) currentBracket[1]) / 100;
      tax += taxPercentage * amount;
      if (income < currentBracket[0]) {
        break;
      }
      idx++;
    }
    return tax;
  }
}
