import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int M, N; //가로 세로

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] box;
    static boolean[][] visited;
    static Queue<Node> q = new LinkedList<>();
    static Node resultNode;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] MN = bf.readLine().split(" ");
        M = Integer.parseInt(MN[1]);
        N = Integer.parseInt(MN[0]);

        box = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String[] line = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(line[j]);

                if (box[i][j] == 1) {
                    q.offer(new Node(i, j, 0));
                }
            }
        }
        int result = tomatoes().day;
        System.out.println(result);
    }

    static Node tomatoes() {

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int k = 0; k < 4; k++) {
                int x = node.x + dx[k];
                int y = node.y + dy[k];

                if (x >= 0 && y >= 0 && x < M && y < N) {

                    if (box[x][y] == 0) {
                        box[x][y] = 1;
                        q.offer(new Node(x, y, node.day + 1));
                    }
                }
            }
            resultNode = node;
        }
        for (int[] ints : box) {
            long count=Arrays.stream(ints).asLongStream().filter(c->c==0).count();
            if(count>0)
                return new Node(0,0,-1);
        }
        return resultNode;
    }


    static class Node {
        int x;
        int y;
        int day;

        Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }


}
//1 익 0 안익 -1없음`