class AuthenticationManager {

  Map<String, Integer> map;
  int timeToLive;

  public AuthenticationManager(int timeToLive) {
    map = new HashMap<>();
    this.timeToLive = timeToLive;
  }

  public void generate(String tokenId, int currentTime) {
    map.put(tokenId, currentTime);
  }

  public void renew(String tokenId, int currentTime) {
    if (map.containsKey(tokenId) && map.get(tokenId) + timeToLive > currentTime) {
      map.put(tokenId, currentTime);
    }
  }

  public int countUnexpiredTokens(int currentTime) {
    return (int) map.entrySet().stream()
        .filter(entry -> entry.getValue() + timeToLive > currentTime).count();
  }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
