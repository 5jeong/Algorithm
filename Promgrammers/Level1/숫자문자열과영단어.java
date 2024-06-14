package Promgrammers.Level1;

public class 숫자문자열과영단어 {
    public int solution(String s) {
        String[] dictionary = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0;i<dictionary.length;i++){
            s = s.replace(dictionary[i],i+"");
        }
        return Integer.parseInt(s);
    }
}
