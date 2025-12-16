import java.util.*;

class Solution {
    public int[] solution(String s) {

          Map<String, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        int[] answer = new int[s.length()];

        int i = 0;
        for (char c : ch) {
            if (map.containsKey(c + "")) {
                int gap = i-map.get(c + "");
                answer[i] = gap;

            } else {
                answer[i] = -1;
            }
            map.put(c + "", i);
            i++;
        }
        
        return answer;
    }
}