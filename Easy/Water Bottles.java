class Solution {
  public int numWaterBottles(int numBottles, int numExchange) {
    int bottleCount = 0;
    int emptyBottles = 0;
    while (numBottles > 0) {
      bottleCount += numBottles;
      emptyBottles += numBottles;
      numBottles = emptyBottles / numExchange;
      emptyBottles %= numExchange;
    }
    return bottleCount;
  }
}
