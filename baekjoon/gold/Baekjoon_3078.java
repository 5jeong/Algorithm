package baekjoon.gold;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/***
 * 좋은 친구
 */
public class Baekjoon_3078 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();

        // 1. 이름 길이별 학생 위치 저장
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map.putIfAbsent(s.length(), new ArrayList<>());
            map.get(s.length()).add(i);
        }

        long ans = 0; // n이 최대 30만이므로 쌍이 Integer 범위를 넘어설수 있음

        // 2. 투 포인터로 좋은 친구 관계 계산
        for (List<Integer> indices : map.values()) {
            int lt = 0;
            for (int rt = 0; rt < indices.size(); rt++) {
                while (indices.get(rt) - indices.get(lt) > k) {
                    lt++;
                }
                ans += rt - lt; // 현재 rt와 lt 사이의 유효한 친구 수
            }
        }

        System.out.println(ans);
    }
}
