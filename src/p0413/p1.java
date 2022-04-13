package p0413;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); /// 수열의 갯수
        int M = sc.nextInt(); // 나누어 떨어져야 하는 수
        long[] S = new long[N]; /// 선언하기 (합 배열 )
        long[] C = new long[M]; /// 선언하기 (같은 나머지의 인덱스를 카운트하는 배열)
        long answer = 0;
        S[0] = sc.nextInt();
        for(int i = 1; i < N; i++){ // 수열 합 배열 만들기
            S[i] = S[i - 1] + sc.nextInt();
        }
        for(int i =0; i < N; i++){
            int remainder = (int) (S[i] % M);
            if(remainder == 0) answer++;
            C[remainder]++;
            // 0 ~ i까지의 구간 합 자체가 0일때 정답에 더하기

        }
        for(int i = 0; i < M; i++){
            if(C[i] > 1){
                // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
                answer = answer + (C[i] * (C[i] - 1) / 2);
            }
        }




    }
}