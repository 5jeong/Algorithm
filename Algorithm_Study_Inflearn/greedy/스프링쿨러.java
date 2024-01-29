package Algorithm_Study_Inflearn.greedy;

import java.util.ArrayList;

public class 스프링쿨러 {
    public static int solution(int n, int[] nums) {
        int answer = 0;
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = i - nums[i];
            int b = i + nums[i];
            arrayList.add(new int[]{Math.max(0, a), Math.min(n, b)});
        }
        arrayList.sort((a, b) -> a[0] - b[0]);
        int s = 0, e = 0, i = 0;
        while (i < arrayList.size()) {
            while (arrayList.get(i)[0] <= s) {
                e = Math.max(e, arrayList.get(i)[1]);
                i++;
            }
            answer++;
            if (e == n) {
                return answer;
            }
            if (s == e) {
                return -1;
            }
            s = e;

        }
//        for (int[] x : arrayList) {
//            if(e==n){
//                answer++;
//                return answer;
//            }
//            if (x[0] <= s) {
//                if (x[1] > e) {
//                    e = x[1];
//                }
//                if(s==e){
//                    return -1;
//                }
//            }
//            else{
//                answer++;
//                s=e;
//                if (x[1] > e) {
//                    e = x[1];
//                }
//            }
//        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
