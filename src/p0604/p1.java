package p0604;
////////////// https://www.hackerrank.com/challenges/two-strings/problem
import java.util.HashSet;
import java.util.Set;

public class p1 {
    public static String twoStrings(String s1, String s2){
        Set<Character> s1Chars = new HashSet<>();

       for(char c : s1.toCharArray()){
           s1Chars.add(c);
       }

       for(char c: s2.toCharArray()){
           if(s1Chars.contains(c)){
               return "YES";
           }
       }
       return "NO";
    }
}


