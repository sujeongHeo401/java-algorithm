package p0609;

public class p1 {
    public static int hamsu(String s){
        for(int i = 0, j = s.length() = 1; i < s.length() / 2; i++, j--)
        if(s.charAt(i) != s.charAt(j)){
            String si = (new StringBuilder(s)).deleteCharAt(i).toString();
            String sj = (new StringBuilder(s)).deleteCharAt(j).toString();
            if(isPalindrome(si)) return i;
            else if(isPalindrome(sj)) return j;
            else return -1;
        }
    return -1;
    }

    static boolean isPalindrome(String s){
        String sr = (new StringBuilder(s)).reverse().toString();
        return s.equals(sr);
    }
}
