class Solution {
  public int countCollisions(String directions) {
    int idx = 0;
    while (idx < directions.length() && directions.charAt(idx) == 'L') {
      idx++;
    }
    int carsFromRight = 0;
    int collisionCount = 0;
    while (idx < directions.length()) {
      if (directions.charAt(idx) == 'R') {
        carsFromRight++;
      } else {
        collisionCount += directions.charAt(idx) == 'S' ? carsFromRight : carsFromRight + 1;
        carsFromRight = 0;
      }
      idx++;
    }
    return collisionCount;
  }
}
