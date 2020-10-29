class Solution {
  public int maxDistToClosest(int[] seats) {
    int numberOfSeats = seats.length;
    int[] distanceFromRight = new int[numberOfSeats];
    int[] distanceFromLeft = new int[numberOfSeats];
    for (int i = 1; i < numberOfSeats; i++) {
      if (seats[i - 1] == 0 && seats[i] == 0) {
          distanceFromLeft[i] = distanceFromLeft[i - 1] + 1;
      }
    }
    for (int i = numberOfSeats - 2; i >= 0; i--) {
      if (seats[i + 1] != 1 && seats[i] == 0) {
          distanceFromRight[i] = distanceFromRight[i + 1] + 1;
      }
    }
    int maxDistance = 0;
    for (int i = 0; i < numberOfSeats; i++) {
      if (i == 0 || i == numberOfSeats - 1) {
        maxDistance = Math.max(
          maxDistance, Math.max(distanceFromLeft[i], distanceFromRight[i])
        );
      } else {
        maxDistance = Math.max(
          maxDistance, Math.min(distanceFromLeft[i], distanceFromRight[i])
        );
      }
    }
    return maxDistance + 1;
  }
}
