class Solution {
  public int countStudents(int[] students, int[] sandwiches) {
    int[] preferenceCount = new int[2];
    for (int preference : students) {
      preferenceCount[preference]++;
    }
    int i = 0;
    for (i = 0; i < sandwiches.length && preferenceCount[sandwiches[i]] > 0; i++) {
      preferenceCount[sandwiches[i]]--;
    }
    return sandwiches.length - i; 
  }
}
