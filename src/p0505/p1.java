package p0505;

import java.util.ArrayList;
import java.util.Scanner;

public class p1 {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    static boolean arrive;
    public static void main(String[] args){
        int N; ///// 노드 개수
        int M; ///// 에지 개수
        arrive = false;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        A = new ArrayList[N];

        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++){
            int S = scan.nextInt();
            int E = scan.nextInt();
            A[S].add(E);
            A[E].add(S);
        }
        for(int i = 0; i < N; i++){
            hello(i, 1);
            if(arrive)
                break;
        }
        if(arrive)
            System.out.println("1");
        else
            System.out.println("0");
    }
    public static void hello(int now , int depth) { //// DFS 구현하기
        if(depth == 5 || arrive){
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int i : A[now]){
            if(!visited[i]){
                hello(i, depth + 1); //// 재귀호출 될 때마다 1 씩 증가
            }
        }
        visited[now] = false;
    }
}
