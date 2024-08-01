package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Member{
    int age;
    String name;
    int idx;

    public Member(int age, String name, int idx) {
        this.age = age;
        this.name = name;
        this.idx = idx;
    }
}

public class P10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        List<Member> lis = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            lis.add(new Member(age,name,i));
        }

        Collections.sort(lis, (m1,m2) ->{
            return m1.age == m2.age ? Integer.compare(m1.idx, m2.idx) : Integer.compare(m1.age,m2.age);
        });

        for (Member li : lis) {
            System.out.println(li.age+" "+li.name);
        }

    }
}
