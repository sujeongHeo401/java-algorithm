package p0428;

import java.io.*;
import java.util.StringTokenizer;

public class p3 {
    public static int[] A, tmp;
    public static long result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N + 1];
        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        result = 0;
        merget_sort(1, N);
        System.out.println(result);
    }

    private static void merget_sort(int s, int e) {
        if(e - s < 1)
            return;
        int m = s + (e - s) / 2;
        // 재귀 함수 형태로 구현하기
        merget_sort(s, m);
        merget_sort(m+1, e);
        for(int i = s; i <= e; i++){
            tmp[i] = A[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while(index1 <= m && index2 <= e){ // 두 그룹을 병합하는 로직
            if(tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                result = result + index2 - k; // 뒤쪽 데이터 값이 작은 경우 result 업데이트
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while(index1 <= m){
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= e){
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
