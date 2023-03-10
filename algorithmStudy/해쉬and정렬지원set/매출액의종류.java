package algorithmStudy.해쉬and정렬지원set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

//슬라이딩 위도우, 투포인터, 해쉬 알고리즘
public class 매출액의종류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr =new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt=0;
        for(int i=0;i<k;i++){
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }
        ans.add(hashMap.size());
        for(int i=k;i<n;i++){
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
            if (hashMap.containsKey(arr[cnt])) {
                hashMap.put(arr[cnt], hashMap.get(arr[cnt]) - 1);
                if(hashMap.get(arr[cnt])==0){
                    hashMap.remove(arr[cnt]);
                }
            }
            cnt++;
            ans.add(hashMap.size());
        }
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
}
