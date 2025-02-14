package baekjoon.silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_11399 {
    static class Person{
        int num;
        int time;
        Person(int num,int time){
            this.num = num;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Person> list = new ArrayList<>();
        int ans =0;

        for(int i=1;i<=n;i++){
            int time = sc.nextInt();
            list.add(new Person(i,time));
        }

        list.sort((a,b)->a.time-b.time);

        int temp=0;
        for(Person p : list){
            temp+=p.time;
            ans+=temp;
        }
        System.out.println(ans);
    }
}
