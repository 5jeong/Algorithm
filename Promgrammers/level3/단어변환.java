package Promgrammers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    static int[] ch;
    static int ans;

    static class Word {
        String word;
        int depth;

        Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }

    public int solution(String begin, String target, String[] words) {
        ans = Integer.MAX_VALUE;
        ch = new int[words.length];
        Queue<Word> queue = new LinkedList<>();

        queue.add(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word now = queue.poll();
            if (now.word.equals(target)) {
                return now.depth;
            }
            for (int j = 0; j < words.length; j++) {
                if (ch[j] == 0 && isPossible(now.word, words[j])) {
                    ch[j] = 1;
                    queue.add(new Word(words[j], now.depth + 1));
                }
            }

        }
        return 0;

        // dfs(0, begin, words, target);
        // words에 없으면 0 반환
        // return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // private void dfs(int L, String now, String[] words, String target) {
    //     if (now.equals(target)) {
    //         ans = Math.min(ans, L);
    //     }
    //     for (int i = 0; i < words.length; i++) {
    //         if (ch[i] == 0 && isPossible(now, words[i])) {
    //             ch[i] = 1;
    //             dfs(L + 1, words[i], words, target);
    //             ch[i] = 0;
    //         }
    //     }
    // }

    // 바꿀수 있는지 확인
    private boolean isPossible(String now, String target) {
        int len = now.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (now.charAt(i) == target.charAt(i)) {
                cnt++;
            }
        }
        return cnt == len - 1;
    }
}
