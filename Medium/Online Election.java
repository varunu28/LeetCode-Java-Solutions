class TopVotedCandidate {

  private TreeMap<Integer, Integer> currWinner;

  public TopVotedCandidate(int[] persons, int[] times) {
    this.currWinner = new TreeMap<>();
    Map<Integer, Integer> candidateToVotecount = new HashMap<>();
    int currWinningCandidate = -1;
    for (int i = 0; i < persons.length; i++) {
      int person = persons[i];
      int newVoteCount = candidateToVotecount.getOrDefault(person, 0) + 1;
      candidateToVotecount.put(person, newVoteCount);
      if (currWinningCandidate == -1 || newVoteCount >= candidateToVotecount.get(currWinningCandidate)) {
        currWinningCandidate = person;
      }
      currWinner.put(times[i], currWinningCandidate);
    }
  }

  public int q(int t) {
    return this.currWinner.floorEntry(t).getValue();
  }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
