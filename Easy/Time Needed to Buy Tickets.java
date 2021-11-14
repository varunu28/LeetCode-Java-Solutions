class Solution {
  public int timeRequiredToBuy(int[] tickets, int k) {
    int timeRequired = 0;
    for(int i = 0;i < tickets.length; i++){
      if(i <= k){
          timeRequired += Math.min(tickets[k], tickets[i]);
      } else {
          timeRequired += Math.min(tickets[k] - 1, tickets[i]);
      }
    }
    return timeRequired;
  }
}
