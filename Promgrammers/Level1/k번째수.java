package Promgrammers.Level1;

import java.util.Arrays;

public class k번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] x : commands) {
            int a = x[0];
            int b = x[1];
            int k = x[2];
            int[] temp = Arrays.copyOfRange(array, a - 1, b);
            Arrays.sort(temp);
            answer[idx++] = temp[k - 1];
//            List<Integer> temp = new ArrayList<>();
//            for(int i = a-1; i < b ; i++ ){
//                temp.add(array[i]);
//            }
//            Collections.sort(temp);
//            answer[idx++] =temp.get(k-1);
        }
        return answer;
    }
}
