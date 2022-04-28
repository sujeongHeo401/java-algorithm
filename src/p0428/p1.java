package p0428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    public static void quickSort(int[] A, int S, int E, int K) {
        if (S < E) {
            int pivot = partition(A, S, E);
            if (pivot == K) //// K 번째 수가 pivot 이면 더 이상 구할 필요 없음
                return;
            else if (K < pivot) /// K 가 pivot보다 작으면 왼쪽 그룹만 정렬 수행하기 
                quickSort(A, S, pivot - 1, K);
            else // K 가 pivot 보다 크면 오른쪽 그룹만 정렬 수행하기
                quickSort(A, pivot + 1, E, K);
        }
    }

    public static int partition(int[] A, int S, int E) {
        int M = (S + E) / 2;
        swap(A, S, M);
        int pivot = A[S];
        int i = S, j = E;
        while (i < j) {
            while (pivot < A[j]) {
                j--;
            }
            while (i < j && pivot >= A[i]) { // 피벗보다 큰 수가 나올때까지 i++
                i++;
            }
            swap(A, i, j);
        }
        //i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
        A[S] = A[i];
        A[i] = pivot;
        return i;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
