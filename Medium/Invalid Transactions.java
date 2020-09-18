class Solution {
  public List<String> invalidTransactions(String[] transactions) {
    Map<String, List<Transaction>> map = new HashMap<>();
    Set<String> invalidTransactions = new HashSet<>();
    for (int i = 0; i < transactions.length; i++) {
      String[] details = transactions[i].split(",");
      String name = details[0];
      int time = Integer.parseInt(details[1]);
      int amount = Integer.parseInt(details[2]);
      String city = details[3];
      if (amount > 1000) {
        invalidTransactions.add(transactions[i]);
      }
      if (map.containsKey(name)) {
        List<Transaction> otherTransactions = map.get(name);
        for (Transaction transaction : otherTransactions) {
          if (!transaction.city.equals(city) && Math.abs(transaction.time - time) <= 60) {
            invalidTransactions.add(transactions[transaction.idx]);
            invalidTransactions.add(transactions[i]);
          }
        }
      }
      map.computeIfAbsent(name, k -> new ArrayList<>()).add(
        new Transaction(name, time, amount, city, i)
      );
    }
    return new ArrayList<>(invalidTransactions);
  }
}


class Transaction {
  String name;
  int time;
  int amount;
  String city;
  int idx;
  
  public Transaction(String name, int time, int amount, String city, int idx) {
    this.name = name;
    this.time = time;
    this.amount = amount;
    this.city = city;
    this.idx = idx;
  }
}
