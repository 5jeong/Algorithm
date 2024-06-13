package Promgrammers.Level1;

import java.lang.ref.PhantomReference;

/*
<문제 풀이 흐름>
1. x가 1이 될때까지 반복
    a. x의 0을 제거 , 0개수 세기 누적 cnt
    b. x의 길이를 2진법 문자열 반환, 변환 횟수 cnt
2. 변한횟수, 0개수 반환
 */
public class 이진변환반복하기 {
    static int zeroCnt;
    static int changeCnt;

    public int[] solution(String s) {
        zeroCnt = 0;
        changeCnt = 0;
        while (!s.equals("1")) {
            s = deleteZero(s);
            s = changeStr(s.length());
        }
        return new int[] {changeCnt,zeroCnt};
    }
    private String deleteZero(String s){
        String deleteZeroStr="";
        for(char x : s.toCharArray()){
            if(x == '0'){
                zeroCnt++;
            }else{
                deleteZeroStr+=x;
            }
        }
        return deleteZeroStr;
    }

    private String changeStr(int length){
        changeCnt++;
        return Integer.toString(length,2);
    }
}
