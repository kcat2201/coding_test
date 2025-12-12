import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n) {
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i <= 200; i++) {
            set.add(i + 1);

        }
        set = set.stream().filter(c -> !(c % 3 ==0) && !String.valueOf(c).contains("3")).collect(Collectors.toList());
        return set.get(n-1);
    }
}

