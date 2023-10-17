package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class 퍼펙트셔플 {

    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int a=0,b=0;
            if(n%2==1){
                a = n/2+1;
                b = n-a;
            }
            else{
                a= n/2;
                b=n/2;
            }
            String[] arr = new String[n];

            for(int i =0;i<n;i++){
                arr[i] = sc.next();
            }
            ArrayList<String> temp = new ArrayList<>();
            ArrayList<String> temp2 = new ArrayList<>();
            ArrayList<String> ans = new ArrayList<>();
            for(int i=0;i<n;i++) {
                if(i<a){
                    temp.add(arr[i]);
                }
                else{
                    temp2.add(arr[i]);
                }
            }

            for(int i=0;i<b;i++){
                ans.add(temp.get(i));
                ans.add(temp2.get(i));
            }
            if(ans.size()!=n){
                ans.add(temp.get(a-1));
            }
            System.out.print("#"+test_case+" ");
            for(String x : ans){
                System.out.print(x+" ");
            }
            System.out.println();

        }
    }
}
