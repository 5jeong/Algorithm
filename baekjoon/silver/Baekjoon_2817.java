package baekjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/***
 * 참가자 5% 미만의 등표를 얻은 사람은 후보에서 제외
 * 스태프 점수 =  득표수 / ( 1,2...14 ) 총 14개 점수가있음
 * 점수 집합은 서로 다른 숫자
 * 스태프가 받은 칩의 개수를 사전순으로 출력
 *
 */
public class Baekjoon_2817 {

    static class PrizeInfo {
        String name;
        int[] scores;
        int count;

        PrizeInfo(String name, int[] scores) {
            this.name = name;
            this.scores = scores;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> scores = new ArrayList<>();
        List<PrizeInfo> prizeInfos = new ArrayList<>();
        double prizeRange = x * 0.05;
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int voteCnt = sc.nextInt();
            if (voteCnt < prizeRange) {
                continue;
            }
            // 점수 기록
            int[] myScore = new int[14];
            for (int j = 1; j <= 14; j++) {
                int score = voteCnt / j;
                myScore[j - 1] = score;
                scores.add(score);
            }
            prizeInfos.add(new PrizeInfo(name, myScore));
        }
        Collections.sort(scores, Comparator.reverseOrder());

        // 칩 갯수 계산
        for (int i = 0; i < 14; i++) {
            int score = scores.get(i);
            for (PrizeInfo prizeInfo : prizeInfos) {
                for (int j = 0; j < 14; j++) {
                    if (score == prizeInfo.scores[j]) {
                        prizeInfo.count++;
                        break;
                    }
                }
            }
        }
        prizeInfos.sort((a, b) -> a.name.compareTo(b.name));
        for (PrizeInfo prizeInfo : prizeInfos) {
            System.out.println(prizeInfo.name + " " + prizeInfo.count);
        }
    }
}
