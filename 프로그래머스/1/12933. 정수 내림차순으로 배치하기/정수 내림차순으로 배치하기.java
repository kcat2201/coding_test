import java.util.*;


class Solution {
    public long solution(long n) {
        long answer = 0;
        
      
         String[] nn = String.valueOf(n).split("");
        Arrays.sort(nn, Collections.reverseOrder());

         answer = Long.valueOf(String.join("", nn));
        return answer;
    }
}