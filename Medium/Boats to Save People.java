class Solution {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int startIdx = 0;
    int endIdx = people.length - 1;
    int count = 0;
    while (startIdx <= endIdx) {
      int currWeight = people[endIdx--];
      if (startIdx <= endIdx && currWeight + people[startIdx] <= limit) {
        currWeight += people[startIdx++];
      }
      count++;
    } 
    return count;
  } 
}
