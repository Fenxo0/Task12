package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean flag = false;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку со скобками: ");
        String stroka = in.nextLine();
        char[] str = stroka.toCharArray();
        for (int i = 0; i < str.length; i++){
            switch (str[i]) {
                case '(':
                    str[i] = '0';
                    flag = Flag1(flag, i, str);
                    break;
                case '{':
                    str[i] = '0';
                    flag = Flag2(flag, i, str);
                    break;
                case '[':
                    str[i] = '0';
                    flag = Flag3(flag, i, str);
                    break;
            }
        }
        if (flag == true) {
            System.out.println("Правильно");
        }
        else {
            System.out.println("Неправильно");
        }
    }

    static boolean Flag1(boolean flag, int i, char[] str){
        for (int j = i; j < str.length; j++){
            if (str[j] == '(') {
                str[j] = '0';
                Flag1(flag, j, str);
            }
            if (str[j] == ')') {
                flag = true;
                str[i] = '0';
                str[j] = '0';
                break;
            }
            else flag = false;
        }
        return flag;
    }

    static boolean Flag2(boolean flag, int i, char[] str){
        for (int j = i; j < str.length; j++){
            if (str[j] == '{'){
                str[j] = '0';
                Flag2(flag, j, str);
            }
            if (str[j] == '}') {
                flag = true;
                str[i] = '0';
                str[j] = '0';
                break;
            }
            else flag = false;
        }
        return flag;
    }

    static boolean Flag3(boolean flag, int i, char[] str){
        for (int j = i; j < str.length; j++){
            if (str[j] == '[') {
                str[i] = '0';
                Flag3(flag, j, str);
            }
            if (str[j] == ']') {
                flag = true;
                str[i] = '0';
                str[j] = '0';
                break;
            }
            else flag = false;
        }
        return flag;
    }
}
