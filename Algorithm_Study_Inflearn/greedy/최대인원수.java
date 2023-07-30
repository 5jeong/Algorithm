package Algorithm_Study_Inflearn.greedy;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class 최대인원수 {

    public static int solution(int n, int[][] trains, int[][] bookings){
        int answer=0;
        int[] sum = new int[n+1];
        for(int[] x : trains){
            sum[x[0]] += x[2];
            sum[x[1]] -= x[2];
        }

        for(int i=1;i<sum.length;i++){
            sum[i] += sum[i-1];
        }
        Arrays.sort(bookings,(a,b)->a[0] - b[0]);
        int idx=0;
        LinkedList<Integer> nums = new LinkedList<>();
        for(int i=1;i<=n;i++) {
            while (!nums.isEmpty() && nums.peek() == i) {
                answer++;
                nums.pollFirst();
            }
            while (idx < bookings.length && bookings[idx][0] == i) {
                nums.add(bookings[idx][1]);
                idx++;
            }
            Collections.sort(nums);
            while (sum[i] < nums.size()) {
                nums.pollLast();
            }
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}
