package Promgrammers;

public class 체육대회 {
    static int answer,n,m;
    static int[] ch;
    static void dfs(int L,int sum,int[][] ability){
        if(L==m){
            answer = Math.max(answer,sum);
        }
        else{
            for(int i=0;i<n;i++){
                if(ch[i]==0){
                    ch[i] = 1;
                    dfs(L+1,sum+ability[i][L],ability);
                    ch[i] = 0;
                }
            }
        }
    }

    public static int solution(int[][] ability) {
        answer = 0;
        n = ability.length;
        m = ability[0].length;
        ch = new int[n];
        dfs(0,0,ability);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}}));
        System.out.println(solution(new int[][]{{20, 30}, {30, 20}, {20, 30}}));

    }

}
