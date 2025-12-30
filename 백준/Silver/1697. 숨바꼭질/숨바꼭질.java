
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int K;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[100001];
        Node result = find();
        System.out.println(result.cnt);
    }

    static Node find() {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N,0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int cx=n.x;
            if (cx == K)
                return n;
            int[] moves = {cx - 1, cx + 1, 2 * cx};


            for (int move : moves) {
                if (move >= 0 && move<=100000&&!visited[move]) {
                    visited[move] = true;
                    queue.offer(new Node(move,n.cnt+1));
                }
            }

        }
        return new Node(0,-1);

    }

    static class Node {

        int x;
        int cnt;

        Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
