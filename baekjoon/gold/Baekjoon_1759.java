package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_1759 {
    static int l,c;
    static ArrayList<String> list;
    static Stack<String> stack;

    // 모음 1개, 자음 2개있는데 검사
    static boolean check(Stack<String> stack){
        String str = "aeiou";
        int cnt1 =0; // 모음 갯수
        int cnt2 =0; // 자음 갯수
        for(String x : stack){
            if(str.contains(x)){
                cnt1++;
            }else{
                cnt2++;
            }
        }
        return cnt1 >=1 && cnt2 >=2;
    }
    static void dfs(int L,int s){
        if(L==l){
            String res="";
            if(check(stack)){
                for(String x : stack){
                    res+=x;
                }
                System.out.println(res);
            }
        }else{
            //조합
            for(int i=s;i<c;i++){
                stack.add(list.get(i));
                dfs(L+1,i+1);
                stack.pop();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<c;i++){
            list.add(st.nextToken());
        }
        // 사전순 정렬
        Collections.sort(list);
        dfs(0,0);

    }
}
