/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int temp = 0;
        while (true) {
            temp = (rand7() - 1) * 7 + (rand7() - 1);
            if (temp < 40) {
                break;
            }
        }
        
        return temp % 10 + 1;
    }
}
