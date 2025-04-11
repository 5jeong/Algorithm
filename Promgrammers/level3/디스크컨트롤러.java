package Promgrammers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    class Job {
        int start;
        int time; // 작업 소요시간

        Job(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 요청 시간순 정렬

        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        int n = jobs.length; // 작업 갯수
        int nowTime = 0; //현재 시간
        int completedCnt = 0; // 처리한 작업 갯수
        int idx = 0;

        int answer = 0;
        while (completedCnt < n) {
            //현재시간 기준 넣을수 있는 작업 넣기
            while (idx < n && jobs[idx][0] <= nowTime) {
                pq.add(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            if (!pq.isEmpty()) {
                Job job = pq.poll();
                nowTime += job.time;
                completedCnt++;
                answer += nowTime - job.start;
            } else {
                nowTime++;
            }
        }
        return answer / n;
    }
}
