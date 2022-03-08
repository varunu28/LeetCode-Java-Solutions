class Solution {
  public int shipWithinDays(int[] weights, int days) {
    int maximumWeight = 0;
    int minimumWeight = weights[0];
    for (int weight : weights) {
      maximumWeight += weight;
      minimumWeight = Math.max(minimumWeight, weight);
    }
    while (minimumWeight <= maximumWeight) {
      int currCapacity = (maximumWeight + minimumWeight) / 2;
      if (isShipmentPossible(weights, days, currCapacity)) {
        maximumWeight = currCapacity - 1;
      } else {
        minimumWeight = currCapacity + 1;
      }
    }
    return minimumWeight;
  }

  private boolean isShipmentPossible(int[] weights, int days, int capacity) {
    int idx = 0;
    while (idx < weights.length) {
      int currWeight = 0;
      while (idx < weights.length && currWeight + weights[idx] <= capacity) {
        currWeight += weights[idx++];
      }
      days--;
    }
    return days >= 0;
  }
}
