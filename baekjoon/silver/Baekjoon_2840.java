package baekjoon.silver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/***
 * 1. 바퀴의 커서를 인덱스를 s만큼 이동
 *  1.0 커서 인덱스가 배열 범위를 넘어가면 조정
 *  1.1 도착한 칸이 아직 알아내지 못한 글자면 기록
 *  1.2 도착한 칸이 글자와 적힌 글자(c)와 다르다면 바퀴는 존재x : !출력
 *  1.3 도착한 칸이 글자와 같다면 넘어감
 * 2. 바퀴에 적힌 글자가 모두 다른지 체크
 * 3. 바퀴에 기록된 글자를 마지막으로 도착한 글자부터 출력
 */
public class Baekjoon_2840 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] tire = new String[n];
        Arrays.fill(tire,"?");
        int cur = 0;
        while (k-- > 0) {
            int s = sc.nextInt();
            String c = sc.next();
            cur = ((cur - s) % n + n) % n;
            // 1.1 도착한 칸이 아직 알아내지 못한 글자면 기록
            if(tire[cur] == "?"){
                tire[cur] = c;
            }
            // 1.2 도착한 칸이 글자와 적힌 글자(c) 와 다르다면 바퀴는 존재x :!출력
            else if(!tire[cur].equals(c)){
                System.out.println("!");
                return;
            }
            // 1.3 도착한 칸이 글자와 같다면 넘어감
            else{
                continue;
            }
        }
        // 2. 바퀴에 적힌 글자가 모두 다른지 체크
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String x : tire){
            if(x.equals("?")) continue;
            hashMap.put(x,hashMap.getOrDefault(x,0)+1);
            if( hashMap.get(x) > 1){
                System.out.println("!");
                return;
            }
        }

        // 3. 바퀴에 기록된 글자를 마지막으로 도착한 글자부터 출력
        for(int i=0;i<n; i++){
            System.out.print(tire[cur]);
            cur = (cur+1) % n;
        }

    }


}
