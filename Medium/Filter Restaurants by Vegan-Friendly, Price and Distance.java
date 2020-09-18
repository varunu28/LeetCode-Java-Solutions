class Solution {
  public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
    List<Integer> indexList = new ArrayList<>();
    for (int i = 0; i < restaurants.length; i++) {
      int[] restaurant = restaurants[i];
      if ((veganFriendly == 0 || restaurant[2] == 1) && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
        indexList.add(i);
      }
    }
    Collections.sort(indexList, new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        int c = restaurants[o2][1] - restaurants[o1][1];
        if (c != 0) {
          return c;
        }
        return restaurants[o2][0] - restaurants[o1][0];
      }
    });
    List<Integer> ans = new ArrayList<>();
    for (Integer index : indexList) {
      ans.add(restaurants[index][0]);
    }
    return ans;
  }
}
