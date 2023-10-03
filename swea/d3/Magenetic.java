package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Magenetic {


    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            ArrayList<String> arrayList  = new ArrayList<>();
            for(int i=0;i<n;i++){
                String temp="";
                for(int j=0;j<n;j++){
                    if(arr[j][i] !=0){
                        temp+=arr[j][i];
                    }
                }
                arrayList.add(temp);
            }

            int ans=0;
            for(String x : arrayList){
                int t=0;
                for(int i=0;i<x.length()-1;){
                    if(x.charAt(i)=='2'){
                        i++;
                        continue;
                    }
                    if(x.charAt(i) != x.charAt(i+1)){
                        ans++;
                        t++;
                        i+=2;
                    }
                    else{
                        i++;
                    }
                }
//                System.out.println("ans : " +ans);
            }
            System.out.println("#"+test_case+" " + ans);

        }
    }
}
