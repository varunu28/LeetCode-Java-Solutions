class Solution {
  public int countStudents(int[] students, int[] sandwiches) {
    int studentIdx = 0;
    int sandwichIdx = 0;
    Map<Integer, Integer> studentState = new HashMap<>();
    while (sandwichIdx < sandwiches.length) {
      if (sandwiches[sandwichIdx] == students[studentIdx]) {
        sandwichIdx++;
        students[studentIdx] = -1;
      } else if (students[studentIdx] != -1) {
        // Check to see if we have finished one complete iteration without consuming any sandwich
        if (studentState.containsKey(studentIdx) && studentState.get(studentIdx) == sandwichIdx) {
          break;
        }
        studentState.put(studentIdx, sandwichIdx);
      }
      studentIdx = studentIdx == students.length - 1 ? 0 : studentIdx + 1;
    }
    return sandwichIdx == sandwiches.length ? 0 : sandwiches.length - sandwichIdx;
  }
}
