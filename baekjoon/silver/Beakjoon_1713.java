package baekjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/***
 * 후보 추천하기
 * 사진틀이 꽉차면, 추천이 가장 적은 학생 삭제
 * 가장 적은 학생이 2명이상이면 가장 오래된 학생 삭제
 *
 *
 */
public class Beakjoon_1713 {
    static class Student {
        int num;
        int cnt; // 추천 횟수
        int period; // 기간 (최근에 받을수록 커짐)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        int minRecommendation;
        for (int i = 0; i < m; i++) {
            int studentNum = sc.nextInt();

            hashMap.put(studentNum, hashMap.getOrDefault(studentNum, 0) + 1);

            // 사진틀이 꽉찰때,
            if (hashMap.size() > n) {
                int cnt = 0;
                minRecommendation = Integer.MAX_VALUE;
                int minKey = 0;
                for (int key : hashMap.keySet()) {
                    // 자기 제외 최소 추천 횟수 구하기
                    if(key == studentNum){
                        continue;
                    }
                    minRecommendation = Math.min(minRecommendation, hashMap.get(key));
                    if (minRecommendation == hashMap.get(key)) {
                        cnt++;
                        minKey = key;
                    }
                }


                // 최소 추천횟수가 2번이상이면 가장 오래된 학생 삭제
                if (cnt >= 2 ) {
                    for (int key : hashMap.keySet()) {
                        if (hashMap.get(key) == minRecommendation) {
                            hashMap.remove(key);
                            break;
                        }
                    }
                } else {
                    hashMap.remove(minKey);
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer key : hashMap.keySet()) {
            ans.add(key);
        }
        Collections.sort(ans);
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
    }
}
