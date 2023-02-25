package algorithmStudy.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 문장속단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split(" ");
        String ans ="";
        ans = arr[0];
        for(int i=1;i<arr.length;i++){
            if(ans.length() < arr[i].length()){
                ans = arr[i];
            }
        }
        System.out.println(ans);

    }
}
