class Solution {
  public int wateringPlants(int[] plants, int capacity) {
    int idx = 0;
    int currCapacity = capacity;
    int totalSteps = 0;
    while (idx < plants.length) {
      if (currCapacity < plants[idx]) {
        currCapacity = capacity;
        totalSteps += 2 * idx;
      }
      currCapacity -= plants[idx++];
      totalSteps++;
    }
    return totalSteps;
  }
}
