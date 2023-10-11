package swea.d3;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class 규영이와인영이의카드게임 {

    static int win,lose;
    static int[] arr1,arr2,ch;
    static int[] num_check;
    static void dfs(int L,int sum1,int sum2){

        if(L==9){
            if(sum1 > sum2){
                win++;
            }
            else{
                lose++;
            }
        }
        else{
            for(int i=0;i<9;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    if(arr1[L] > arr2[i]){ //규영이가 큰경우
                       dfs(L+1,sum1+arr1[L]+arr2[i],sum2);
                   }
                   else{ //인영이가 큰경우
                       dfs(L+1,sum1,sum2+arr1[L]+arr2[i]);
                   }
                    ch[i]=0;
                }
            }
        }
    }
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
//        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            arr1 = new int[9]; //규영이 배열
            arr2 = new int[9]; //인영이 배열
            win=0;
            lose=0;
            ch = new int[9];
            num_check=new int[19];
            for(int i=0;i<9;i++ ){
                arr1[i] = sc.nextInt();
                num_check[arr1[i]]=1;
            }

            int t=0;
            for(int i=1;i<=18;i++){
                if(num_check[i]==0){
                    arr2[t]=i;
                    t++;
                }
            }

            dfs(0,0,0);

            System.out.println("#"+test_case+" "+win+" "+lose);

        }
    }
}