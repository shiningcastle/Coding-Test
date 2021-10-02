import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    private static int leafCount = 0;

    private static void findLeaf(int node, int parent, List<Integer>[] graph) {
        for (int son : graph[node]) {
            if (son == parent) {
                if (graph[node].size() == 1) // 부모 노드만 연결된 리프노드 경우
                    leafCount++;
                continue;
            }
            findLeaf(son, node, graph);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), root = 0;
        List<Integer>[] graph = new ArrayList[n];
        int[] whereParent = new int[n];
        // 그래프 리스트 초기화
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            whereParent[i] = parent;
            if (parent == -1) // 루트 노드 위치 저장
                root = i;
            else
                graph[parent].add(i); // 해당 노드를 부모 노드에 양방향 연결(루트노드는 -1이므로 제외)
            graph[i].add(parent);
        }
        int target = Integer.parseInt(br.readLine());
        br.close();
        if (target != root) { // 제거할 트리가 루트인 경우 답은 0
            List<Integer> par = graph[whereParent[target]];
            for (int i = 0; i < par.size(); i++) { // 지울 타겟의 루트 노드에서 타겟 노드 제거
                if (par.get(i) == target)
                    par.remove(i);
            }
            findLeaf(root, -1, graph); // 삭제할 서브트리를 제거후 전체트리 탐색
        }
        System.out.print(leafCount);
    }
}