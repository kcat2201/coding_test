
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt(); //computer count
        int N = sc.nextInt(); //connected;
        graph = new ArrayList[C + 1];
        visited = new boolean[C + 1];
        for (int i = 1; i <= C; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }


        virus(1);
        System.out.println(count - 1);
    }

    private static void virus(int n) {
        visited[n] = true;
        count++;

        for (int nn : graph[n]) {
            if (!visited[nn]) {
                virus(nn);
            }

        }
    }

}