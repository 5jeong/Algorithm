package swea.d3;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 단순2진암호코드 {


    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] num = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] arr = new char[n][m];
            String secret="";
            for(int i=0;i<n;i++){
                String temp=sc.next();
                for(int j=0;j<temp.length();j++){
                    arr[i][j] = temp.charAt(j);
                }
            }

            int cnt=0;
            boolean flag=false;
            for(int i=0;i<n;i++){
                if(flag){
                    break;
                }
                for(int j=0;j<m-1;j++){
                    if(arr[i][j]=='1'){
                        for(int k=j;k<j+56;k++){
                            secret+=arr[i][k];
                        }
                        flag=true;
                        break;
                    }
                }
            }
            int t=0;
            String t1="";
            for(int i=55;i>0;i--){
                if(secret.charAt(i)=='0'){
                    t++;
                    t1+=secret.charAt(i);
                }
                if(secret.charAt(i)=='1'){
                    break;
                }
            }
            secret=  secret.substring(0,56-t);
            secret = t1+secret;


            String res="";
            for(int i=0;i<56;i+=7){
                String temp = secret.substring(i,i+7);
                for(int j=0;j<num.length;j++){
                    if(num[j].equals(temp)){
                        res+=j;
                        break;
                    }
                }
            }
            int a=0,b=0;
            for(int i=0;i<res.length();i++){
                if(i%2==0){
                    a+= Integer.parseInt(String.valueOf(res.charAt(i)));
                }
                else{
                    b+=Integer.parseInt(String.valueOf(res.charAt(i)));
                }
            }
            int temp = a*3 +b;
            int ans=0;
            if(temp%10==0){
                ans = a+b;
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}
