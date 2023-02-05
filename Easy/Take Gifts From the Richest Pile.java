class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long totalGifts = 0;
        for (int gift : gifts) {
            pq.add(gift);
            totalGifts += gift;
        }
        while (k-- > 0) {
            int removedGift = pq.poll();
            int remainingGift = (int) Math.sqrt(removedGift);
            totalGifts -= removedGift - remainingGift;
            pq.add(remainingGift);
        }
        return totalGifts;
    }
}
