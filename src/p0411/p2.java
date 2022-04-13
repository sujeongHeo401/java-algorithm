package p0411;
import java.util.Scanner;
public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 과목 수 입력 받기
        int A[] = new int[N]; // 길이가 N 인 1차원 배열 A[] 선언하기
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt(); // A에 각 정수 저장하기
        }

        long max = 0;
        long sum = 0;
        for(int i = 0; i < N; i++){ // 길이 만큼 반복하기
            if(A[i] > max) max = A[i];// 최고점은 변수 max 에,
            sum = sum + A[i]; // 총점은 변수 sum 에 저장하기
        }

        System.out.println(sum * 100.0 / max / N);
    }
}
