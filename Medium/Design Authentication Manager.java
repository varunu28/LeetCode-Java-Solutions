class AuthenticationManager {

    private final int timeToLive;
    private final LinkedHashMap<String, Integer> tokens;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokens = new LinkedHashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        Integer expiration = tokens.get(tokenId);
        if (expiration == null || expiration <= currentTime) {
            if (expiration != null) {
                tokens.remove(tokenId);
            }
            return;
        }
        tokens.remove(tokenId);
        tokens.put(tokenId, currentTime + timeToLive);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        Iterator<Map.Entry<String, Integer>> iterator = tokens.entrySet().iterator();
        while (iterator.hasNext() && iterator.next().getValue() <= currentTime) {
            iterator.remove();
        }
        return tokens.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
