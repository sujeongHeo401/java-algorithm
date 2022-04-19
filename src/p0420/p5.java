package p0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p5 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] A  = new int[N];
//        for(int i = 0; i < N; i++){
//            A[i] = sc.nextInt();
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A  = new int[N];
        for(int i = 0; i < N; i++){
            int request = Integer.parseInt(br.readLine());
            A[i] = request;
        }
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < N - 1 - i; j++){
                if(A[j] > A[j + 1]){
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < N; i++){
            System.out.println(A[i]);
        }

    }
}
