package p0516;

public class p1 {
    public static String hackerrankInString(String s) {
        // Write your code here
        String str = "hackerrank";
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            if(j < str.length() && s.charAt(i) == str.charAt(j)){
                j++;
            }
        }

        return (j == str.length() ? "YES" : "NO");

    }
}


/////https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
