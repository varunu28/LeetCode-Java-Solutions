class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] ans;
        int i = 0;
        Stack<Integer> stack = new Stack<>();

        while (i < asteroids.length) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            }
            else if (asteroids[i] < 0) {
                if (stack.peek() > 0) {
                    int temp = stack.pop();
                    if (temp > Math.abs(asteroids[i])) {
                        stack.push(temp);
                    }
                    else if (temp == Math.abs(asteroids[i])) {
                        i++;
                        continue;
                    }
                    else {
                        continue;
                    }
                }
                else {
                    stack.push(asteroids[i]);
                }
            }
            else {
                stack.push(asteroids[i]);
            }

            i++;
        }

        ans = new int[stack.size()];
        i = stack.size()-1;

        while (i >= 0) {
            ans[i] = stack.pop();
            i--;
        }

        return ans;
    }
}
