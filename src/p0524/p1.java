package p0524;

import java.util.HashSet;
import java.util.List;

public class p1 {
    public static int gemstones(List<String> arr) {
        System.out.println("arr.size() : " +arr.size());
        HashSet<Integer> set1 = new HashSet<Integer>();
        int[] intArray = new int[26];

        int answer = 0;
        for(int j = 0; j < arr.size(); j++){
            for(int z = 0; z < arr.get(j).length(); z++){
                set1.add((int) arr.get(j).charAt(z) - 97);
            }
            for(int ii : set1){
                intArray[ii]++;
                if(intArray[ii] >= arr.size()){
                    System.out.println("where ????");
                    answer++;
                }
            }
            set1.clear();
        }
        return answer;


        // Write your code here
    }

}
