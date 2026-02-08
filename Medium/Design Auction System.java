class AuctionSystem {

    private final Map<Integer, TreeSet<Bid>> itemIdToBidMapping;
    private final Map<Integer, Map<Integer, Bid>> userIdToBidMapping;

    public AuctionSystem() {
        this.itemIdToBidMapping = new HashMap<>();
        this.userIdToBidMapping = new HashMap<>();
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        if (this.userIdToBidMapping.containsKey(userId) && this.userIdToBidMapping.get(userId).containsKey(itemId)) {
            cleanup(userId, itemId);
        }
        addNewBid(userId, itemId, bidAmount);
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        cleanup(userId, itemId);
        addNewBid(userId, itemId, newAmount);
    }

    public void removeBid(int userId, int itemId) {
        cleanup(userId, itemId);
    }

    public int getHighestBidder(int itemId) {
        if (!itemIdToBidMapping.containsKey(itemId) || itemIdToBidMapping.get(itemId).isEmpty()) {
            return -1;
        }
        return itemIdToBidMapping.get(itemId).first().userId;
    }

    private void addNewBid(int userId, int itemId, int bidAmount) {
        Bid newBid = new Bid(userId, bidAmount, itemId);
        itemIdToBidMapping.computeIfAbsent(itemId, _ -> new TreeSet<>()).add(newBid);
        userIdToBidMapping.computeIfAbsent(userId, _ -> new HashMap<>()).put(itemId, newBid);
    }

    private void cleanup(int userId, int itemId) {
        Bid existingBid = this.userIdToBidMapping.get(userId).get(itemId);
        userIdToBidMapping.get(userId).remove(itemId);
        itemIdToBidMapping.get(itemId).remove(existingBid);
    }

    record Bid(int userId, int amount, int itemId) implements Comparable<Bid> {
        @Override
        public int compareTo(Bid other) {
            if (this.amount == other.amount) {
                return Integer.compare(other.userId, this.userId);
            }
            return  Integer.compare(other.amount, this.amount);
        }
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */
