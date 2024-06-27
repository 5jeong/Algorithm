package Promgrammers.Level1;

import java.util.Set;
import java.util.TreeSet;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        Set<Integer> res = new TreeSet<>();
        int len = numbers.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                res.add(numbers[i] + numbers[j]);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
