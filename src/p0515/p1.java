package p0515;

public class p1 {
    public static int marsExploration(String s) {
        int answer = 0;
        char[] s1 = s.toCharArray();

        for (int i = 0; i < s1.length; i++){
            char curr = s1[i];
            if((i % 3 == 0 || i % 3 == 2)){
                if(curr != 'S') answer ++;
            }
            else if(i % 3 == 1){
                if(curr != 'O') answer ++;
            }
        }
        // Write your code here
        return answer;

    }
}


/////https://www.hackerrank.com/challenges/mars-exploration/problem