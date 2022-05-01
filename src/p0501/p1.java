package p0501;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/////////  출처 : https://www.hackerrank.com/challenges/equality-in-a-array/problem
public class p1 {
    public static int equalizeArray(List<Integer> a){
        int max = 1;
        Map<Integer, Integer> nums = new HashMap<>();
        for(int i : a){
            if(!nums.containsKey(i))
                nums.put(i, 1);
            else{
                nums.put(i, nums.get(i) + 1);
                if(max < nums.get(i))
                    max = nums.get(i);
            }
        }
        return a.size() - max;

    }
}
