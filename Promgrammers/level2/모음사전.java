package Promgrammers.level2;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {
    private static List<String> dic;
    private static char[] chars = {'A', 'E', 'I', 'O', 'U'};

    private void generate(String word) {
        dic.add(word);
        if (word.length() == 5) {
            return;
        }
        for (char x : chars) {
            generate(word + x);
        }
    }

    public int solution(String word) {
        int answer = 0;
        dic = new ArrayList<>();
        generate("");
        for (int i = 1; i < dic.size(); i++) {
            if (dic.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
