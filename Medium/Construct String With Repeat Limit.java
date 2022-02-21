class Solution {
  public String repeatLimitedString(String s, int repeatLimit) {
    PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (char c : s.toCharArray()) {
      pq.add(c);
    }
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    int currentCharacterCount = 0;
    char previousCharacter = pq.peek();
    while (!pq.isEmpty()) {
      char currChar = pq.poll();
      if (currChar == previousCharacter) {
        if (currentCharacterCount < repeatLimit) {
          sb.append(currChar);
        } else {
          stack.add(currChar);
        }
        currentCharacterCount++;
      } else {
        if (stack.isEmpty()) {
          sb.append(currChar);
          previousCharacter = currChar;
          currentCharacterCount = 1;
        } else {
          sb.append(currChar);
          currentCharacterCount = 0;
          while (!stack.isEmpty() && currentCharacterCount < repeatLimit) {
            sb.append(stack.pop());
            currentCharacterCount++;
          }
        }
      }
    }
    return sb.toString();
  }
}
