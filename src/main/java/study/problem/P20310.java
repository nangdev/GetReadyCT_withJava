package study.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P20310 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        List<Character> list = new ArrayList<>();

        int len = arr.length;

        for (char c : arr) {
            list.add(c);
        }

        int even_cnt = 0, odd_cnt = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == '0') {
                even_cnt++;
            } else {
                odd_cnt++;
            }
        }

        even_cnt /= 2;
        odd_cnt /= 2;

        int idx = 0;
        while (odd_cnt > 0) {
            if (arr[idx] == '1') {
                list.remove(Character.valueOf('1'));
                odd_cnt--;
            }
            idx++;
        }

        idx = len - 1;
        while (even_cnt > 0) {
            if (arr[idx] == '0') {
                list.remove(list.lastIndexOf(Character.valueOf('0')));
                even_cnt--;
            }
            idx--;
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}