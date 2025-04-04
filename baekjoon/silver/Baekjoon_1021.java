package baekjoon.silver;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

// 회전하는 큐
public class Baekjoon_1021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        List<Integer> pick = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            pick.add(sc.nextInt());
        }
        int ans = 0;
        Deque<Integer> leftDeque = new ArrayDeque<>(deque);
        Deque<Integer> rightDeque = new ArrayDeque<>(deque);
        for (int x : pick) {
            int leftCnt = 0;
            int rightCnt = 0;
            while (leftDeque.peekFirst() != x) {
                left(leftDeque);
                leftCnt++;
            }
            leftDeque.pollFirst();
            while (rightDeque.peekFirst() != x) {
                right(rightDeque);
                rightCnt++;
            }
            rightDeque.pollFirst();
            if(leftCnt < rightCnt){
                rightDeque = new ArrayDeque<>(leftDeque);
                ans += leftCnt;
            }else{
                leftDeque = new ArrayDeque<>(rightDeque);
                ans += rightCnt;
            }
        }
        System.out.println(ans);
    }

    private static void left(Deque<Integer> deque) {
        int temp = deque.pollFirst();
        deque.addLast(temp);
    }

    private static void right(Deque<Integer> deque) {
        int temp = deque.pollLast();
        deque.addFirst(temp);
    }
}
