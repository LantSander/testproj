package com.ts;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author chenhd
 * @date 2022/2/15 7:15 下午
 */
public class Stage1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputNum = input.next();
        char[] chars = inputNum.toCharArray();

        String rs = chars.length > 1 ? printChart(Integer.parseInt(String.valueOf(chars[0])), Integer.parseInt(String.valueOf(chars[1]))) : printChart(Integer.parseInt(String.valueOf(chars[0])), null);

        System.out.println(rs);
    }



    public static List<char[]> charList = new ArrayList<>();

    static {
        List<String> list = new ArrayList();
        list.add("ABC");
        list.add("DEF");
        list.add("GHI");
        list.add("JKL");
        list.add("MNO");
        list.add("PQRS");
        list.add("TUV");
        list.add("WXYZ");

        for (int i = 0; i < list.size(); i++) {
            char[] chars = list.get(i).toCharArray();
            charList.add(chars);
        }

    }

    public static String printChart(Integer a, Integer b) {
        if (Objects.isNull(a)) {
            return null;
        }
        String rs = "";

        if (a < 2) {
            if (Objects.isNull(b)) {
                return null;
            }
            if (b < 2) {
                return null;
            }
            char[] chars = charList.get(b - 2);
            for (int i = 0; i < chars.length; i++) {
                rs += chars[i] + " ";
            }
            return rs;
        }

        a = a - 2;
        b = Objects.isNull(b) ? null : b > 2 ? b - 2 : null;

        if (Objects.isNull(b)) {
            char[] chars = charList.get(a);
            for (int i = 0; i < chars.length; i++) {
                rs += chars[i] + " ";
            }
        } else {
            char[] aChars = charList.get(a);
            char[] bChars = charList.get(b);

            for (int i = 0; i < aChars.length; i++) {
                for (int j = 0; j < bChars.length; j++) {
                    rs += aChars[i] + "" + bChars[j] + " ";
                }
            }
        }
        return rs;
    }

}
