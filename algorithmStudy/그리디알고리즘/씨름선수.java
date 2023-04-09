package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 씨름선수 {
    static class Person implements Comparable<Person> {
        int h,w;
        Person(int h,int w){
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Person o) {
            return o.h -this.h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Person> people = new ArrayList<>();
        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            people.add(new Person(h,w));
        }
        Collections.sort(people);
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(Person x  : people){
            if(x.w > max){
                max = x.w;
                ans++;
            }
        }
        System.out.println(ans);

    }
}
