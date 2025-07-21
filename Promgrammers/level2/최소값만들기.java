package Promgrammers.level2;

import java.util.Arrays;

public class 최소값만들기 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Integer[] arr = new Integer[B.length];

        for (int i = 0; i < B.length; i++) {
            arr[i] = B[i];
        }

        Arrays.sort(arr, (a, b) -> b - a);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * arr[i];
        }
        return answer;
    }
}
