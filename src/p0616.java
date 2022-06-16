package jagorithm;
import java.util.*;
import java.lang.StringBuilder;

public class P3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("ASAASS")); ///// 115
		System.out.println(solution("SSA")); ////// 80 
		System.out.println(solution("SSSSAAA")); ///////// 175

	}
	public static int solution(String R) {
		int prefix = 0;
		int suffix = 0;
		int answer = (int)1e9;
		for(int i = 0; i < R.length() + 1; i++) {
			String prefix1 = R.substring(0, i);
			String suffix1 = R.substring(i, R.length());
			answer = (int) Math.min(answer, (countChar(prefix1, 'A')* 5 + countChar(prefix1, 'S') * 40) +
					(countChar(suffix1, 'A') * 20 + countChar(suffix1, 'S')* 30)
						);
		}
		return answer;

    }
    public static int countChar(String str, char ch) {
        return (int) str.chars().filter(c -> c == ch).count();
    }

}


/////trivial problem
/////////https://app.codility.com/programmers/challenges/
