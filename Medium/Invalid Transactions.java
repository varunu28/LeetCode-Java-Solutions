class Solution {
  public List<String> invalidTransactions(String[] transactions) {
    Set<String> invalidTransactionSet = new HashSet<>();
    Map<String, List<String>> map = new HashMap<>();
    Map<String, Integer> transactionOccurenceCount = new HashMap<>();
    for (String transactionString : transactions) {
      transactionOccurenceCount.put(transactionString, transactionOccurenceCount.getOrDefault(transactionString, 0) + 1);
      String[] transaction = transactionString.split(",");
      String name = transaction[0];
      int amount = Integer.parseInt(transaction[2]);
      String city = transaction[3];
      int time = Integer.parseInt(transaction[1]);
      if (amount > 1000) {
        invalidTransactionSet.add(transactionString);
      } 
      map.computeIfAbsent(name, k -> new ArrayList<>());
      List<String> currentTransactions = map.get(name);
      for (String currentTransaction : currentTransactions) {
        String currentCity = currentTransaction.split(",")[3];
        int currentTime = Integer.parseInt(currentTransaction.split(",")[1]);
        if (!currentCity.equals(city) && Math.abs(time - currentTime) <= 60) {
          invalidTransactionSet.add(currentTransaction);
          invalidTransactionSet.add(transactionString);
        }
      }
      currentTransactions.add(transactionString);
      map.put(name, currentTransactions);
    }
    List<String> result = new ArrayList<>();
    for (String trs : invalidTransactionSet) {
      int count = transactionOccurenceCount.get(trs);
      while (count-- > 0) {
        result.add(trs);
      }
    }
    return result;
  }
}
