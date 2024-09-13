package Promgrammers.level2;

public class 스킬트리 {
    public static int solution(String skill, String[] skill_trees) {
        int cnt = 0;
        for(String x : skill_trees){
            x = x.replaceAll("[^"+skill+"]","");
            cnt += skill.indexOf(x) == 0 ? 1 : 0;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBD",new String[]{"BACDE","CBADF","AECB","BDA"}));
    }
}
