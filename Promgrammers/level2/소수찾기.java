package Promgrammers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 문제풀이흐름 (완전탐색) 1. 문자열 numbers를 int[] nums로 변환 2. 모든 문자열로 만들수 있는 숫자 탐색 - 만들어진 숫자가 소수이면 res추가 - 사용한 숫자가 아닐때만 재귀 ( ch[i]
 * = false) 3. res의 길이 반환
 */
public class 소수찾기 {
    static Set<Integer> res;
    static boolean[] ch;

    private boolean isPrime(int num) {
        if(num <=1) return false;
        for(int i=2;i*i<=num;i++){
            if( num % i == 0){
                return false;
            }
        }
        return true;
    }

    private void dfs(int num, List<Integer> nums, boolean[] ch) {

    }

    public int solution(String numbers) {
        int answer = 0;
        res = new HashSet<>();
        ch = new boolean[numbers.length()];
        List<Integer> nums = new ArrayList<>();
        for (char x : numbers.toCharArray()) {
            res.add(x + '0');
        }
        dfs(0, nums, ch);

        return answer;
    }
}
