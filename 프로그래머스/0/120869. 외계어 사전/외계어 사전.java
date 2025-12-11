import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        int[] cnt = new int[spell.length];
        String str=List.of(spell).stream().collect(Collectors.joining(""));
        List<String> list = Arrays.stream(dic).filter(c -> c.length() == spell.length).collect(Collectors.toList());
        for (String s : list) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))|| str.indexOf(s.charAt(i))<0)
                    break;
                else
                    map.put(s.charAt(i), 1);
            }
            int result = map.values().stream().reduce(1, (a, b) -> a * b);
            if (result == 1 &&
                    map.keySet().size() == spell.length) {
                answer = 1;
            }
        }
        return answer;
    }
}