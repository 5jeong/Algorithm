package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 회문2 {

    static boolean palindrome(String str){
        int lt=0;
        int rt=str.length()-1;
        while(lt<rt){
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

        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=10;
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            char[][] arr = new char[100][100];
            for(int i=0;i<100;i++){
                String a = sc.next();
                for(int j=0;j<100;j++){
                    arr[i][j] = a.charAt(j);
                }
            }

            int ans=0;
            int len =100;
            boolean flag= false;
            for(int i=100;i>0;i--){
                if(flag){
                    break;
                }
                for(int j=0;j<100;j++){
                    if(flag){
                        break;
                    }
                    for(int k = 0;k<=100-i;k++){
                        String temp1="";
                        String temp2="";
                        for(int s = k;s<k+i;s++){
                            temp1+=arr[j][s];
                            temp2+=arr[s][j];
                        }
                        if(palindrome(temp1)==true || palindrome(temp2)==true){
                            ans=temp1.length();
                            flag=true;
                            break;
                        }
                    }
                }

            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}
