package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 정곤이의단조증가하는수 {

    static boolean check(int n){
        String str = String.valueOf(n);
        int t= str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(t > str.charAt(i)){
                   return false;
            }
            t=str.charAt(i);
        }
        return true;
    }
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] num = new int[n];
            for(int i=0;i<n;i++){
                num[i]= sc.nextInt();
            }
            int ans=0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    int temp = num[i] *num[j];
                    if(check(temp)==true){
                        ans = Math.max(ans,temp);
                    }
                }
            }
            if(ans==0){
                System.out.println("#"+test_case+" "+-1);
            }
            else{
                System.out.println("#"+test_case+" "+ans);
            }
        }
    }
}