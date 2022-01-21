class Logger {
  
  private final Map<String, Integer> logger;
  
  public Logger() {
    this.logger = new HashMap<>();
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    if (this.logger.containsKey(message) && timestamp - this.logger.get(message) < 10) {
      return false;
    }
    this.logger.put(message, timestamp);
    return true;
  }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
