class Solution {
  public int numFriendRequests(int[] ages) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int age : ages) {
      map.put(age, map.getOrDefault(age, 0) + 1);
    }
    int totalFriendRequests = 0;
    for (Integer ageOne : map.keySet()) {
      for (Integer ageTwo : map.keySet()) {
        if (!((ageTwo <= 0.5 * ageOne + 7) || (ageTwo > ageOne) || (ageTwo > 100 && ageOne < 100))) {
          totalFriendRequests += map.get(ageOne) * (map.get(ageTwo) - (ageOne == ageTwo ? 1 : 0));
        }
      }
    }
    return totalFriendRequests;
  }
}
