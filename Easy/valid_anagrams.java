import java.util.Arrays;
public class Solution {
    public boolean isAnagram(String s, String t) {
            char[] schar = s.toCharArray();
            char[] tchar = t.toCharArray();
            Arrays.sort(schar);
            Arrays.sort(tchar);
            s = new String(schar);
            t = new String(tchar);
            return s.equals(t);
        }
    }
