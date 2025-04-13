package Promgrammers.level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

    public int[] solution(String[] operations) {
        int[] answer = {};
        int n;
        n = operations.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (String s : operations) {
            String op = s.split(" ")[0];
            int target = Integer.parseInt(s.split(" ")[1]);
            switch (op) {
                case "I" -> {
                    minHeap.add(target);
                    maxHeap.add(target);
                }
                case "D" -> {
                    //둘다 비어있으면
                    if (minHeap.isEmpty()) {
                        continue;
                    }
                    if (target == 1) {
                        minHeap.remove(maxHeap.poll());
                    } else {
                        maxHeap.remove(minHeap.poll());
                    }
                }
            }

        }
        int min = minHeap.isEmpty() ? 0 : minHeap.peek();
        int max = maxHeap.isEmpty() ? 0 : maxHeap.peek();

        return new int[]{max, min};
    }
}
