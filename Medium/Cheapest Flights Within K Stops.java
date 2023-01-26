class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], ArrayList::new).add(new int[]{flight[1], flight[2]});
        }
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        while (k-- >= 0 && !queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] removed = queue.remove();
                int currCity = removed[0];
                int currPrice = removed[1];
                if (!graph.containsKey(currCity)) {
                    continue;
                }
                for (int[] node : graph.get(currCity)) {
                    int nextCity = node[0];
                    int flightPrice = node[1];
                    if (currPrice + flightPrice < price[nextCity]) {
                        price[nextCity] = currPrice + flightPrice;
                        queue.add(new int[]{nextCity, price[nextCity]});
                    }
                }
            }
        }
        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }
}
