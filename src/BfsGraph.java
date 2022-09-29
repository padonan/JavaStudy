import java.util.*;

class BfsGraph {
    private int V;
    private LinkedList<Integer> adj[];

    BfsGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    /* BFS */
    void BFS(int s) {
        boolean[] visited = new boolean[V]; // 방문여부 확인용 변수
        LinkedList<Integer> queue = new LinkedList<Integer>(); // 연결리스트 생성

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
            s = queue.poll();
            System.out.print(s + " ");

            // 방문한 노드와 인접한 모든 노드를 가져온다.
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();

                // 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BfsGraph bfsGraph = new BfsGraph(10); // 노드의 갯수를 10개로 설정


        // DfsGraph와 같은 구조의 노드구성입니다.
        bfsGraph.addEdge(0, 1);  // 노드간의 연결
        bfsGraph.addEdge(0, 2);
        bfsGraph.addEdge(1, 2);
        bfsGraph.addEdge(2, 3);
        bfsGraph.addEdge(3, 4);
        bfsGraph.addEdge(4, 5);
        bfsGraph.addEdge(4, 6);
        bfsGraph.addEdge(5, 7);
        bfsGraph.addEdge(5, 6);
        bfsGraph.addEdge(6, 8);
        bfsGraph.addEdge(7, 9);
        bfsGraph.addEdge(8, 2);
        bfsGraph.addEdge(9, 1);
        bfsGraph.addEdge(9, 5);

        bfsGraph.BFS(0);

        // print ( 0 1 2 3 4 5 6 7 8 9 )
    }
}
