package p0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1 {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 에지 개수
        A = new ArrayList[n + 1]; // 그래프 데이터 저장 인접 리스트
        visited = new boolean[n + 1]; // 방문 기록 저장 배열
        for(int i = 1; i < n + 1; i++){
            A[i] = new ArrayList<Integer>(); ///인전 리스트에 데이터 저장하기
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e); /// 양방향으로 더하기
            A[e].add(s);
        }

        int count = 0;
        for(int i = 1; i < n + 1; i++){
            if(!visited[i]){
                count++;
                DFS(I);
            }
        }
        
    }
}
