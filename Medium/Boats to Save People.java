class Solution {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int count = 0;
    int start = 0;
    int end = people.length - 1;
    while (end >= start) {
      if (people[start] + people[end] <= limit) {
        start++;
      }
      end--;
      count++;
    }
    return count;
  }
}
