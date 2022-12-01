package algorithmStudy.해쉬and정렬지원set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


//슬라이딩 위도우, 투포인터, 해쉬 알고리즘
public class 매출액의종류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        int[] ans = new int[n-k+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt=0;
        for(int rp=0;rp<n;rp++){
            HashMap<Integer,Integer> map = new HashMap<>();

        }
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
}
