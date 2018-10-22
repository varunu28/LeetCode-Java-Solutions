/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int person1 = stack.pop();
            int person2 = stack.pop();

            if (knows(person1, person2)) {
                stack.push(person2);
            }
            else {
                stack.push(person1);
            }
        }
        
        int person = stack.pop();
        for (int i=0; i<n; i++) {
            if (i != person && (knows(person, i) || !knows(i, person))) {
                return -1;
            }
        }
        
        return person;
    }
}
