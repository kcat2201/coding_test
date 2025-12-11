import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] wallpaper) {
              int[] answer = new int[4];


        int x = wallpaper.length;
        int y = wallpaper[0].length();

        int lux = 0;
        int luy = 0;
        int rdx = x;
        int rdy = y;

        for (String s : wallpaper) {
            if (s.contains("#")) {
                break;
            } else {
                lux++;
            }
        }

        List<String> rdxs = new ArrayList<>(Arrays.asList(wallpaper));
        Collections.reverse(rdxs);

        for (String s : rdxs) {
            if (s.contains("#")) {
                break;
            } else {
                rdx--;
            }
        }

        for (String s : wallpaper) {
            s.split("");
        }
        List<String> ys = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            int finalI = i;
            String str = Arrays.stream(wallpaper).map(c -> String.valueOf(c.charAt(finalI))).collect(Collectors.joining());
            ys.add(str);
        }


        for (String s : ys) {
            if (s.contains("#")) {
                break;
            } else {
                luy++;
            }
        }


        Collections.reverse(ys);

        for (String s : ys) {
            if (s.contains("#")) {
                break;
            } else {
                rdy--;
            }
        }

        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx;
        answer[3] = rdy;

        return answer;
    }
}