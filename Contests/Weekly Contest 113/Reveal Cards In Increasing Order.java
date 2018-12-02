class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] ans = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        Arrays.sort(deck);
        deque.addFirst(deck[n-1]);
        
        for (int i=n-2; i>=0; i--) {
            int temp = deque.removeLast();
            deque.addFirst(temp);
            deque.addFirst(deck[i]);
        }
        
        int idx = 0;
        while (!deque.isEmpty()) {
            ans[idx++] = deque.pollFirst();
        }
        
        return ans;
    }
}
