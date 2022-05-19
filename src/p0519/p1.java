package p0519;

public class p1 {
    public static String funnyString(String s) {
        char[] sc = s.toCharArray();
        for(int i = 1, j = sc.length - 1; i < sc.length; i++,j--){
            if(Math.abs(sc[i] - sc[i-1]) != Math.abs(sc[j] - sc[j-1])){
                return "Not Funny";
            }

        }
        return "Funny";
        // Write your code here

    }
}

/// 해커랭크 https://www.hackerrank.com/challenges/funny-string/problem