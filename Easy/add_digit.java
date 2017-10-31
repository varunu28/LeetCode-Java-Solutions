//Solution with running time O(1)

public class Solution {
    public int addDigits(int num) {
        if(num!=0)
        {
            if(num%9!=0)
            {
                return num%9;
            }
            else
            {
                return 9;
            }  
        }
        else
        {
            return 0;
        }
    }
}
