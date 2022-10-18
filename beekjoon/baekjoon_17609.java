package beekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String tmp = " ";

        int lt = 0, rt = str.length() - 1;
        while(lt < rt){
            if(str.charAt(lt) == str.charAt(rt)){
                lt++;
                rt--;
            }
            else{
                str.charAt(lt)
            }
        }
    }
}
