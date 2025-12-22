import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int j = 1; j <= N; j++) {
            if (!visited[j]) {
                count++;
                connected(j);
            }
        }
        System.out.println(count);
    }

    private static void connected(int n) {
        visited[n] = true;

        for (Integer i : graph[n]) {
            if (!visited[i]) {
                connected(i);
            }
        }
}

}