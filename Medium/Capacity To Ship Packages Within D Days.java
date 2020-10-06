class Solution {
  public int shipWithinDays(int[] weights, int D) {
    int maxWeight = weights[0];
    int totalWeight = 0;
    for (int weight : weights) {
      maxWeight = Math.max(maxWeight, weight);
      totalWeight += weight;
    }
    while (maxWeight < totalWeight) {
      int midWeight = (maxWeight + totalWeight) / 2;
      int need = 1;
      int curr = 0;
      for (int weight : weights) {
        if (curr + weight > midWeight) {
            need += 1;
            curr = 0;
        }
        curr += weight;
      }
      if (need > D) {
        maxWeight = midWeight + 1;
      }
      else {
        totalWeight = midWeight;
      }
    }
    return maxWeight;
  }
}
