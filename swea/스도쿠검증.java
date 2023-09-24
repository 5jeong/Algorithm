package swea;

import java.io.FileInputStream;
import java.util.Scanner;

public class 스도쿠검증 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[] col_ch = new int[10];
            int[] row_ch = new int[10];
            int[] ch = new int[10];
            int[][] arr = new int[9][9];
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    arr[i][j] =sc.nextInt();
                }
            }
            boolean flag= true;
            for(int i=0;i<9;i++){
                col_ch = new int[10];
                row_ch = new int[10];
                for(int j=0;j<9;j++){
                    col_ch[arr[i][j]]++;
                    row_ch[arr[j][i]]++;
                    if(col_ch[arr[i][j]] > 1 || row_ch[arr[i][j]] > 1){
                        flag=false;
                    }
                }
            }

            for(int i=0;i<=6;i+=3){
                for(int j=0;j<=6;j+=3){
                    int a = i+3;
                    int b = j+3;
                    ch = new int[10];
                    for(int s = i ; s<a; s++){
                        for(int k=j;k<b;k++){
                            ch[arr[s][k]]++;
                            if(ch[arr[s][k]] > 1){
                                flag=false;
                            }
                        }
                    }
                }
            }
            int ans =0;
            if(flag==true){
                System.out.println("#"+test_case+" "+"1");
            }
            else{
                System.out.println("#"+test_case+" "+"0");
            }
        }
    }
}
