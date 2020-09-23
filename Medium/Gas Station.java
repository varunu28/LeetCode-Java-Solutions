class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int tankCapacity = 0;
    int currTankCapacity = 0;
    int startingStation = 0;
    for (int i = 0; i < n; i++) {
      tankCapacity += gas[i] - cost[i];
      currTankCapacity += gas[i] - cost[i];
      if (currTankCapacity < 0) {
        startingStation = i + 1;
        currTankCapacity = 0;
      }
    }
    return tankCapacity >= 0 ? startingStation : -1;
  }
}
