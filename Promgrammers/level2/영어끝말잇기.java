package Promgrammers.level2;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
    /*
     탈락조건 : 이미 사용한 단어 말하거나, 엉뚱한 단어로 말할떄 탈락
     아무도 탈락 안하는 경우 : 0,0
     */
    static Set<String> set;

    public int[] solution(int n, String[] words) {
        set = new HashSet<>();
        char pre = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!isPossible(words[i], pre)) {
                int player = (i % n) + 1;
                int turn = (i / n) + 1;
                return new int[]{player, turn};
            }
            pre = words[i].charAt(words[i].length() - 1);
            set.add(words[i]);
        }

        return new int[]{0, 0};
    }

    private boolean isPossible(String nowWord, char pre) {
        return nowWord.charAt(0) == pre && !set.contains(nowWord);
    }

}
