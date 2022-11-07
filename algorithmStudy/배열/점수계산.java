package algorithmStudy.배열;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] score = new int[n];
        int ans = 0, cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                score[i] = cnt;
            } else if (arr[i] == 0) {
                cnt = 0;
                score[i] = cnt;
            }
        }
        for(int i=0;i<score.length;i++){
            ans += score[i];
        }
        System.out.println(ans);
    }
}
