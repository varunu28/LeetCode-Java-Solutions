class TopVotedCandidate {
    int[] times;
    int[] persons;
    int[] winner;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.persons = persons;
        int[] counter = new int[persons.length+1];
        winner = new int[times.length];
        int max = Integer.MIN_VALUE;
        int maxPerson = -1;
        int i = 0;

        while (i < times.length) {
            counter[persons[i]]++;
            if (max < counter[persons[i]]) {
                max = counter[persons[i]];
                maxPerson = persons[i];
            }
            else if (max == counter[persons[i]]) {
                maxPerson = persons[i];
            }

            winner[i] = maxPerson;

            i++;
        }
    }

    public int q(int t) {
        int i = 0;
        while (i < times.length && times[i] <= t) {
            i++;
        }

        return winner[i-1];
    }
}


/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
