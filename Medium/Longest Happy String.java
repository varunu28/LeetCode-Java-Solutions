class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<LetterFrequencyPair> pq =
                new PriorityQueue<>((p, q) -> q.frequency() - p.frequency());
        if (a > 0) {
            pq.add(new LetterFrequencyPair('a', a));
        }
        if (b > 0) {
            pq.add(new LetterFrequencyPair('b', b));
        }
        if (c > 0) {
            pq.add(new LetterFrequencyPair('c', c));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            LetterFrequencyPair removed = pq.remove();
            int frequency = removed.frequency();
            int resultLength = sb.length();
            if (resultLength >= 2 &&
                    sb.charAt(resultLength - 1) == removed.letter() &&
                    sb.charAt(resultLength - 2) == removed.letter()) {
                if (pq.isEmpty()) {
                    break;
                }
                LetterFrequencyPair temp = pq.remove();
                sb.append(temp.letter());
                if (temp.frequency() - 1 > 0) {
                    pq.add(new LetterFrequencyPair(temp.letter(), temp.frequency() - 1));
                }
            } else {
                sb.append(removed.letter());
                frequency--;
            }
            if (frequency > 0) {
                pq.add(new LetterFrequencyPair(removed.letter(), frequency));
            }
        }
        return sb.toString();
    }

    private record LetterFrequencyPair(char letter, int frequency) {}
}
