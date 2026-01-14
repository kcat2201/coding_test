import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.valueOf(bf.readLine());
        Set<String> set=new HashSet<>();
        StringBuilder sb = new StringBuilder();

        String nn=bf.readLine();
        String[] numbers=nn.split(" ");

        for (String number : numbers) {
            set.add(number);
        }
        int M=Integer.valueOf(bf.readLine());
        String mm=bf.readLine();

        String[] mum=mm.split(" ");
        for (String s : mum) {
            sb.append(set.contains(s)?"1\n":"0\n");
        }
        System.out.println(sb);

    }
}
