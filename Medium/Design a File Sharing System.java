class FileSharing {
  Map<Integer, Set<Integer>> chunkToUserMap;
  Map<Integer, Set<Integer>> userToChunkMap;
  int id;
  PriorityQueue<Integer> availableIds;
  public FileSharing(int m) {
    id = 1;
    chunkToUserMap = new HashMap<>();
    userToChunkMap = new HashMap<>();
    for (int i = 1; i <= m; i++) {
      chunkToUserMap.put(i, new HashSet<>());
    }
    availableIds = new PriorityQueue<>();
  }

  public int join(List<Integer> ownedChunks) {
    int userId = getUserId();
    userToChunkMap.put(userId, new HashSet<>(ownedChunks));
    for (Integer chunk : ownedChunks) {
      chunkToUserMap.get(chunk).add(userId);
    }
    return userId;
  }
  
  private int getUserId() {
    if (availableIds.isEmpty()) {
      return id++;
    }
    return availableIds.poll();
  }

  public void leave(int userID) {
    Set<Integer> chunksOwned = userToChunkMap.get(userID);
    userToChunkMap.remove(userID);
    for (Integer chunk : chunksOwned) {
      chunkToUserMap.get(chunk).remove(userID);
    }
    availableIds.add(userID);
  }

  public List<Integer> request(int userID, int chunkID) {
    Set<Integer> usersOwningChunk = chunkToUserMap.get(chunkID);
    Iterator<Integer> iterator = usersOwningChunk.iterator();
    List<Integer> users = new ArrayList<>();
    while (iterator.hasNext()) {
      users.add(iterator.next());
    }
    if (!usersOwningChunk.contains(userID) && usersOwningChunk.size() > 0) {
      userToChunkMap.get(userID).add(chunkID);
      chunkToUserMap.get(chunkID).add(userID);
    }
    Collections.sort(users);
    return users;
  }
}

/**
 * Your FileSharing object will be instantiated and called as such:
 * FileSharing obj = new FileSharing(m);
 * int param_1 = obj.join(ownedChunks);
 * obj.leave(userID);
 * List<Integer> param_3 = obj.request(userID,chunkID);
 */
