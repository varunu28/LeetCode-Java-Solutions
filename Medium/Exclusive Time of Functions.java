class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] timer = new int[n];
        Stack<Integer> stack = new Stack<>();
        int lastTime = 0;;

        for (String log : logs) {
            String[] strs = log.split(":");
            int id = Integer.parseInt(strs[0]);
            String status = strs[1];
            int time = Integer.parseInt(strs[2]);

            if (!stack.isEmpty()) {
                timer[stack.peek()] += time - lastTime;
            }
            lastTime = time;
            if (status.equals("start")) {
                stack.push(id);
            }
            else {
                timer[stack.pop()]++;
                lastTime++;
            }
        }

        return timer;
    }
}
