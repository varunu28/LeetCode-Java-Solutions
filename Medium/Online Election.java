class TopVotedCandidate {

    Map<Integer, Integer> voteCount;
    Map<Integer, Integer> timeCount;
    int currLeaderCount;
    List<Winner> winners;

    public TopVotedCandidate(int[] persons, int[] times) {
        voteCount = new HashMap<>();
        timeCount = new HashMap<>();
        currLeaderCount = 0;
        winners = new ArrayList<>();
        
        for (int i = 0; i < persons.length; i++) {
            boolean isPresent = voteCount.containsKey(persons[i]);
            voteCount.put(persons[i], voteCount.getOrDefault(persons[i], 0) + 1);
            timeCount.put(persons[i], times[i]);
            if (voteCount.get(persons[i]) >= currLeaderCount) {
                winners.add(new Winner(persons[i], times[i]));
                currLeaderCount = Math.max(currLeaderCount, voteCount.get(persons[i]));
            }
        }
    }

    public int q(int t) {
        return winners.get(binarySearchHelper(winners, 0, winners.size() - 1, t)).val;
    }

    private int binarySearchHelper(List<Winner> winners, int left, int right, int target) {
        int idx = winners.size();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (winners.get(mid).time == target) {
                idx = mid;
                break;
            }
            else if (winners.get(mid).time < target) {
                idx = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return idx == winners.size() ? 0 : idx;
    }
}

class Winner {
    int val;
    int time;

    public Winner(int val, int time) {
        this.val = val;
        this.time = time;
    }
}
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
