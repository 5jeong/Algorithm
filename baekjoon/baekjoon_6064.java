package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int temp = n - m;

            int dy = x ;
            int ans = x;
            boolean flag = true;
            while(dy!=y){
                dy -= temp;
                if(dy <= 0){
                    dy += n;
                    ans+= m;
                    continue;
                }
                else if(dy > n){
                    dy -= n;
                    ans +=m;
                    continue;
                }
                ans += m;
                if(dy==x){
                    ans = -1;
                    break;
                }
            }
            result.add(ans);
        }
        for(int x : result){
            System.out.print(x+ " ");
        }
    }
}
