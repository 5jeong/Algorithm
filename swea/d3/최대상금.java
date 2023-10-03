package swea.d3;

import java.io.FileInputStream;
import java.util.*;

class 최대상금
{
    static int[] arr;
    static int ans,cnt;
    static void dfs(int s,int change){
        if(change == cnt){
            String str = "";
            for(int x : arr){
                str+=x;
            }
            int num = Integer.parseInt(str);
            ans = Math.max(ans,num);
            return;

        }
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                dfs(0,change+1);

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }

    }
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = sc.next();
            cnt = sc.nextInt();
            ans=0;
            arr =new int[str.length()];
            int t=0;
            for(int i=0;i<str.length();i++){
                arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            if(cnt  > str.length()){
                cnt = str.length();
            }
            dfs(0,0);
            System.out.println("#"+test_case+" "+ans);
        }
    }
}