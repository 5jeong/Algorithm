package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.util.HashMap;

public class Solution {
    public static int solution(String s){

        int[] index_list = {16,6,5,3,12,14,11,11,17,12,7};
        String str = "cvsgiorszzzmrpaqpe";
        String ans = " ";
        for(int x : index_list){
            for(char y : str.toCharArray()){
                if(str.charAt(x)==y ){
                    ans+=y;
                    break;
                }
            }
        }
        System.out.println(ans);

        return -1;
    }

    public static void main(String[] args){
        System.out.println(solution("statitsics"));
        System.out.println(solution("aabb"));
        System.out.println(solution("stringshowtime"));
        System.out.println(solution("abcdeabcdfg"));
    }
}
