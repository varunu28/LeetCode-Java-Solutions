class Solution {
    public int maxRequests(int[][] requests, int k, int window) {
        Map<Integer, List<Integer>> userToRequestMapping = new HashMap<>();
        for (int[] request : requests) {
            int user = request[0];
            int time = request[1];
            userToRequestMapping.computeIfAbsent(user, _ -> new ArrayList<>()).add(time);
        }
        int result = requests.length;
        for (Integer user : userToRequestMapping.keySet()) {
            List<Integer> requestTimes = userToRequestMapping.get(user);
            Collections.sort(requestTimes);
            Deque<Integer> queue = new ArrayDeque<>();
            for (Integer time : requestTimes) {
                queue.addLast(time);
                if (queue.size() > k) {
                    if (queue.peekLast() - queue.peekFirst() <= window) {
                        queue.pollLast();
                        result--;
                    } else {
                        queue.pollFirst();
                    }
                }
            }
        }
        return result;
    }
}
