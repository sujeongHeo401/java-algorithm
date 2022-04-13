package p0411;

import java.util.Scanner;
public class p1 {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        // 입력값을 String 형 변수 sNum 에 저장한 수 char[]형 변수로 변환하기
//        String sNum = sc.next();
//        char[] cNum = sNum.toCharArray();
//        int sum = 0;
//        for(int i = 0; i < cNum.length; i++){
//            sum += cNum[i] - '0'; //cNum을 정수형으로 변환하면서 sum 에 더하여 누적하기
//        }
//        System.out.print(sum);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(int i = 0; i < cNum.length; i++){
            sum += cNum[i] - '0';
        }
        System.out.print(sum);
    }
}
