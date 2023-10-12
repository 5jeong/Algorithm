package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 다트게임 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        double[] arr = {Math.pow(20,2),Math.pow(40,2),Math.pow(60,2),Math.pow(80,2),Math.pow(100,2),Math.pow(120,2),Math.pow(140,2),Math.pow(160,2),Math.pow(180,2),Math.pow(200,2),};
//        T=1;
        for (int test_case = 1; test_case <= T; test_case++) {
            st= new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int ans=0;
            for(int i=0;i<n;i++){
                st= new StringTokenizer(br.readLine());
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());
                double dis = Math.pow(x,2) + Math.pow(y,2);
                for(int j=0;j<10;j++){
                   if(dis <= arr[j]){
                       ans+= 10-j;
                       break;
                   }
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}