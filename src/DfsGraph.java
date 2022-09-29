import java.util.*;

/* 인접 리스트를 이용한 방향성 있는 그래프 클래스 */
public class DfsGraph {
    private int V;   // 노드의 개수
    private LinkedList<Integer> adj[]; // 인접 리스트

    /** 생성자 */
    DfsGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) // 인접 리스트 초기화
            adj[i] = new LinkedList();
    }

    /** 노드를 연결 v->w */
    void addEdge(int v, int w) { adj[v].add(w); }

    /** DFS에 의해 사용되는 함수 */
    void DFSUtil(int v, boolean[] visited) {
        // 현재 노드를 방문한 것으로 표시하고 값을 출력
        visited[v] = true;
        System.out.print(v + " ");

        // 방문한 노드와 인접한 모든 노드를 가져온다.
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
            if (!visited[n])
                DFSUtil(n, visited); // 순환 호출
        }
    }

    /** 주어진 노드를 시작 노드로 DFS 탐색 */
    void DFS(int v) {
        // 노드의 방문 여부 판단 (초깃값: false)
        boolean visited[] = new boolean[V];

        // v를 시작 노드로 DFSUtil 순환 호출
        DFSUtil(v, visited);
    }

    /** DFS 탐색 */
    void DFS() {
        // 노드의 방문 여부 판단 (초깃값: false)
        boolean visited[] = new boolean[V];

        // 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
        for (int i=0; i<V; ++i) {
            if (!visited[i])
                DFSUtil(i, visited);
        }
    }

    public static void main(String[] args) {
        DfsGraph dfsGraph = new DfsGraph(10);  // 노드의 갯수를 10개로 설정

        dfsGraph.addEdge(0, 1);  // 노드간의 연결
        dfsGraph.addEdge(0, 2);
        dfsGraph.addEdge(1, 2);
        dfsGraph.addEdge(2, 3);
        dfsGraph.addEdge(3, 4);
        dfsGraph.addEdge(4, 5);
        dfsGraph.addEdge(4, 6);
        dfsGraph.addEdge(5, 7);
        dfsGraph.addEdge(5, 6);
        dfsGraph.addEdge(6, 8);
        dfsGraph.addEdge(7, 9);
        dfsGraph.addEdge(8, 2);
        dfsGraph.addEdge(9, 1);
        dfsGraph.addEdge(9, 5);

        // print( 0 1 2 3 4 5 7 9 6 8 0 1 2 3 4 5 7 9 6 8 )


        dfsGraph.DFS(0); /* 주어진 노드를 시작 노드로 DFS 탐색 */
        dfsGraph.DFS(); /* 비연결형 그래프의 경우 */

    }
}
