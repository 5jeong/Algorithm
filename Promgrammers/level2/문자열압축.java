package Promgrammers.level2;

import java.util.ArrayList;

/*
<문제풀이 흐름>
1. 1부터 입력 문자열 s길이만큼 자를 길이 설정해서 반복
2. 설정 길이만큼 배열에 저장
3. 배열을 비교해서 문자열 압축
4. 가장 짧은 문자열 리턴
 */
public class 문자열압축 {
    public static int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length(); i++) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int j = 0; j < s.length(); j += i) {
                int endIdx = j + i;
                if (endIdx > s.length()) {
                    endIdx = s.length();
                }
                String str2 = s.substring(j, endIdx);
                arrayList.add(str2);
            }
            min = Math.min(min, compress(arrayList).length());
        }
        return min;
    }

    private static String compress(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        String token = arrayList.get(0);
        int cnt = 1;
        for (int i = 1; i < arrayList.size(); i++) {
            if (!token.equals(arrayList.get(i))) {
                if (cnt > 1) {
                    sb.append(cnt);
                }
                sb.append(token);
                token = arrayList.get(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        if (cnt > 1) {
            sb.append(cnt);
        }
        sb.append(token);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));

    }
}
