package algorithmStudy.스택and큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 크레인인형뽑기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        int ans=0;
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] moves = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            moves[i] = Integer.parseInt(st.nextToken());
            moves[i]--;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int temp =board[j][moves[i]];
                if(!stack.isEmpty() && stack.peek()==temp){
                    stack.pop();
                    board[j][moves[i]]=0;
                    ans++;
                    break;
                }
                if(temp!=0){
                    stack.push(temp);
                    board[j][moves[i]]=0;
                    break;
                }

            }
        }
        System.out.println(ans*2);
    }
}
