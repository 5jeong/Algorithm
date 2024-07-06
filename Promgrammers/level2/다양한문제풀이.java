package Promgrammers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 다양한문제풀이 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> scoresMap = buildScoresMap(info);
        for (int i = 0; i < answer.length; i++) {
            //정답 구하기
            answer[i] = count(query[i], scoresMap);
        }
        return answer;
    }

    private int count(String query, Map<String, List<Integer>> scoresMap) {
        // scoresMap을 이용해 query에 맞는 지원자 수 세기
        String[] tokens = query.split(" (and )?");
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

        if (!scoresMap.containsKey(key)) {
            return 0;
        }
        List<Integer> scores = scoresMap.get(key);
        int score = Integer.parseInt(tokens[tokens.length - 1]);
        int cnt = 0;
//        for (int x : scores) {
//            if (score <= x) {
//                cnt++;
//            }
//        }
//        return cnt;
        return scores.size() - binarySearch(score, scoresMap.get(key));
    }

    private int binarySearch(int score, List<Integer> scores) {
        // 이진탐색으로 인덱스 찾기
        int start = 0;
        int end = scores.size() - 1;
        while (end > start) {
            //중간 값에 따라 범위 좁히기
            int mid = (start + end) / 2;
            if (scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (scores.get(start) < score) {
            return scores.size();
        }
        return start;
    }

    private void forEachKey(int index, String prefix, String[] tokens, List<String> keys) {
        if (index == tokens.length - 1) {
            //prefix가 만들어진 검색조건
            keys.add(prefix);
            return;
        }
        forEachKey(index + 1, prefix + tokens[index], tokens, keys);
        forEachKey(index + 1, prefix + "-", tokens, keys);
    }


    private Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();
        // 전처리
        //scoreMap에 추가
        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            List<String> keys = new ArrayList<>();
            forEachKey(0, "", tokens, keys);
            for (String key : keys) {
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            }
        }
        for (List<Integer> x : scoresMap.values()) {
            Collections.sort(x);
        }

        return scoresMap;
    }

    public static void main(String[] args) {
        String s = "java backend junior pizza 150";
        String[] tokens = s.split(" ");
        int score = Integer.parseInt(tokens[tokens.length - 1]);

        System.out.println(Arrays.toString(tokens));
    }

}
