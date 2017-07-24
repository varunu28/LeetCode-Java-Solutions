import java.util.ArrayList;
public class Solution {
    public int majorityElement(int[] num) 
	{
	int major = num[0];
	int appears = 1;

	for (int i = 1, count = num.length; i < count; ++i){
		if (num[i] == major) {
			appears ++;
		} else if (appears == 0) {
			appears ++;
			major = num[i];
		} else {
			appears --;
		}
	}

	return major;
    }
}