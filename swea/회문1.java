package swea;

import java.io.FileInputStream;
import java.util.Scanner;

public class 회문1 {
    static boolean palindrome(String str){
        int lt=0;
        int rt= str.length()-1;
        while(lt < rt){
            if(str.charAt(lt) != str.charAt(rt)){
                return false;
            }
            lt++;
            rt--;
        }
        return true;
    }

    public static void main(String args[]) throws Exception
    {

//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=10;
        for(int test_case = 1; test_case <= T; test_case++) {
            int ans=0;
            int len = sc.nextInt();
            char[][] arr = new char[8][8];
            for(int i=0;i<8;i++){
                String a = sc.next();
                for(int j=0;j<8;j++){
                    arr[i][j] = a.charAt(j);
                }
            }
            int n = 8-len+1;
            for(int i=0;i<8;i++){
                for(int j=0;j<n;j++){
                    String temp="";
                    String temp2="";
                    for(int k=j;k<j+len;k++){
                        temp+=arr[i][k];
                        temp2+=arr[k][i];
                    }
                    if(palindrome(temp) == true ){
                        ans++;
                    }
                    if(palindrome(temp2) == true){
                        ans++;
                    }
                }
            }
            System.out.println("#"+test_case+" " + ans);
        }
    }
}
