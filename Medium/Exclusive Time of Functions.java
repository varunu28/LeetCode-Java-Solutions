class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int lastTimestamp = 0;
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            int timestamp = Integer.parseInt(split[2]);
            if (split[1].equals("start")) {
                // We consider timestamp as part of current computation 
                if (!stack.isEmpty()) {
                    result[stack.peek()] += timestamp - lastTimestamp;
                }
                stack.push(id);
                lastTimestamp = timestamp;
            } else {
                // We consider timestamp as part of previous computation
                result[stack.pop()] += timestamp - lastTimestamp + 1;
                lastTimestamp = timestamp + 1;
            }
        }
        return result;
    }
}
