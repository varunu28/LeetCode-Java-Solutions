class Solution {
  public int minDeletions(String s) {
    int[] frequency = new int[26];
    for (char c : s.toCharArray()) {
      frequency[c - 'a']++;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int freq : frequency) {
      if (freq > 0) {
        pq.add(freq);
      }
    }
    int numOfDeletions = 0;
    while (!pq.isEmpty()) {
      int removedFreq = pq.poll();
      if (!pq.isEmpty() && pq.peek() == removedFreq) {
        numOfDeletions++;
        if (removedFreq > 1) {
          pq.add(removedFreq - 1);
        }
      }
    }
    return numOfDeletions;
  }
}
