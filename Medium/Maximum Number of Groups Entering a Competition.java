class Solution {
  public int maximumGroups(int[] grades) {
    int numOfGroups = 0;
    int n = grades.length;
    int groupSize = 1;
    int totalGrades = 0;
    while (totalGrades < n) {
      totalGrades += ++groupSize;
      numOfGroups++;
    }
    return numOfGroups;
  }
}
