class TopVotedCandidate {

  List<Winner> winners;
  public TopVotedCandidate(int[] persons, int[] times) {
    winners = new ArrayList<>();
    Map<Integer, Integer> countMap = new HashMap<>();
    Map<Integer, Integer> timeMap = new HashMap<>();
    int maxVotes = 0;
    for (int i = 0; i < persons.length; i++) {
      countMap.put(persons[i], countMap.getOrDefault(persons[i], 0) + 1);
      timeMap.put(persons[i], times[i]);
      if (countMap.get(persons[i]) >= maxVotes) {
        winners.add(new Winner(times[i], persons[i]));
        maxVotes = Math.max(maxVotes, countMap.get(persons[i]));
      }
    }
  }

  public int q(int t) {
    return winners.get(binarySearchHelper(t)).val;
  }
  
  private int binarySearchHelper(int target) {
    int start = 0;
    int end = winners.size() - 1;
    int idx = 0;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (winners.get(mid).time == target) {
        idx = mid;
        break;
      }
      else if (winners.get(mid).time < target) {  
        idx = mid;
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }
    return idx == winners.size() ? 0 : idx;
  }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */

class Winner {
  int time;
  int val;
  
  public Winner(int time, int val) {
    this.time = time;
    this.val = val;
  }
}
