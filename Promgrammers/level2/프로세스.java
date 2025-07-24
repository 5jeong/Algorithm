package Promgrammers.level2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로세스 {
    class Process {
        int num;
        int priority;

        Process(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Process> pq = new PriorityQueue<>((a, b) -> b.priority - a.priority);
        Queue<Process> queue = new LinkedList<>();
        int n = priorities.length;

        for (int i = 0; i < n; i++) {
            Process process = new Process(i, priorities[i]);
            pq.add(process);
            queue.add(process);
        }

        while (!pq.isEmpty()) {
            Process now = queue.poll();
            Process top = pq.peek();

            if (now.priority == top.priority) {
                pq.poll();
                answer++;
                if (now.num == location) {
                    return answer;
                }
            } else {
                queue.add(now);
            }
        }
        return answer;
    }
}
