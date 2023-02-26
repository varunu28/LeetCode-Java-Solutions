class FileSharing {

    private final PriorityQueue<Integer> userIdsInSystem;
    private final Map<Integer, Set<Integer>> chunkToUserIdMapping;
    private final Map<Integer, Set<Integer>> userIdToChunkMapping;

    public FileSharing(int m) {
        this.userIdsInSystem = new PriorityQueue<>();
        this.userIdsInSystem.add(1);
        this.chunkToUserIdMapping = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            chunkToUserIdMapping.put(i, new HashSet<>());
        }
        this.userIdToChunkMapping = new HashMap<>();
    }

    public int join(List<Integer> ownedChunks) {
        int currUserId = this.userIdsInSystem.poll();
        if (this.userIdsInSystem.isEmpty()) {
            this.userIdsInSystem.add(currUserId + 1);
        }
        this.userIdToChunkMapping.computeIfAbsent(currUserId, k -> new HashSet<>());
        for (Integer chunk : ownedChunks) {
            this.chunkToUserIdMapping.get(chunk).add(currUserId);
            this.userIdToChunkMapping.get(currUserId).add(chunk);
        }
        return currUserId;
    }

    public void leave(int userID) {
        this.userIdsInSystem.add(userID);
        Set<Integer> chunksOwned = this.userIdToChunkMapping.get(userID);
        this.userIdToChunkMapping.remove(userID);
        for (Integer chunk : chunksOwned) {
            this.chunkToUserIdMapping.get(chunk).remove(userID);
        }
    }

    public List<Integer> request(int userID, int chunkID) {
        if (this.chunkToUserIdMapping.get(chunkID).isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> usersOwningChunk = this.chunkToUserIdMapping.get(chunkID).stream().sorted().toList();
        this.userIdToChunkMapping.get(userID).add(chunkID);
        this.chunkToUserIdMapping.get(chunkID).add(userID);
        return usersOwningChunk;
    }
}

/**
 * Your FileSharing object will be instantiated and called as such:
 * FileSharing obj = new FileSharing(m);
 * int param_1 = obj.join(ownedChunks);
 * obj.leave(userID);
 * List<Integer> param_3 = obj.request(userID,chunkID);
 */
