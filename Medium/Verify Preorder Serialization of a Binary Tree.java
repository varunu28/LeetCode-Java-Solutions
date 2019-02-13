class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] array = preorder.split(",");
        
        for (String node : array) {
            if (node.equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
                stack.push(node);
            }
            else {
                stack.push(node);
            }
        }
        
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
