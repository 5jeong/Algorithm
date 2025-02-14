package baekjoon.silver;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/***
 * 맥주 축제
 * N 일동안 맥주 N병을 마심
 * 맥주 도수가 간 레벨보다 높으면 x
 * 마시는 맥주 N개의 선호도 합이 M이상
 * 간 레벨의 최솟값 출력
 *
 */
public class Baekjoon_17503 {

    static class Beer {
        int prefer; // 선호도
        int alcohol; // 도수

        Beer(int prefer, int alcohol) {
            this.prefer = prefer;
            this.alcohol = alcohol;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 마셔야 하는 맥주 수
        int m = sc.nextInt(); // 선호도 최소 합
        int k = sc.nextInt(); // 맥주 종류
        List<Beer> beers = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            beers.add(new Beer(sc.nextInt(), sc.nextInt()));
        }

        // 1. 도수(alcohol) 기준으로 오름차순 정렬 (도수가 같다면 선호도 큰 순)
        beers.sort((a, b) -> a.alcohol == b.alcohol ? b.prefer - a.prefer : a.alcohol - b.alcohol);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙 (선호도)
        int sum = 0, ans = -1;

        // 2. 도수가 낮은 순서대로 맥주를 선택
        for (Beer beer : beers) {
            pq.add(beer.prefer);
            sum += beer.prefer;

            // 3. N개 초과하면 가장 낮은 선호도 제거
            if (pq.size() > n) {
                sum -= pq.poll();
            }

            // 4. 정확히 N개를 선택했으며, 선호도 합이 M 이상이면 도수 기록 후 종료
            if (pq.size() == n && sum >= m) {
                ans = beer.alcohol;
                break;
            }
        }

        System.out.println(ans);
    }
}
