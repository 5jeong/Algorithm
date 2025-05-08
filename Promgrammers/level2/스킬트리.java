package Promgrammers.level2;

import java.util.Arrays;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {

        return (int) Arrays.stream(skill_trees)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .count();
    }
}
