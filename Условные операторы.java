package org.example;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ex8_1();

    }

    public static void Ex1(){

        Scanner in = new Scanner(System.in);
        int userNum;

        System.out.print("Введите число: ");
        userNum = in.nextInt();

        if(userNum % 3 == 0) {
            System.out.println("Число " + userNum + " делится на 3");
        } else {
            System.out.println("Число " + userNum + " не делится на 3");
        }
    }

    public static void Ex2(){

        Scanner in = new Scanner(System.in);
        int userNum;

        System.out.print("Введите число: ");
        userNum = in.nextInt();

        if (userNum % 5 == 2 && userNum % 7 == 1) {
            System.out.println("Число " + userNum + " удовлетворяет заданным условиям!");
        } else {
            System.out.println("Число " + userNum + " не удовлетворяет заданным условиям!");
        }
    }

    public static void Ex3(){

        Scanner in = new Scanner(System.in);
        int userNum;

        System.out.print("Введите число: ");
        userNum = in.nextInt();

        if (userNum % 4 == 0 && userNum >= 10){
            System.out.println("Число " + userNum + " удовлетворяет заданным условиям!");
        } else {
            System.out.println("Число " + userNum + " не удовлетворяет заданным условиям!");
        }
    }

    public static void Ex4(){

        Scanner in = new Scanner(System.in);
        int userNum;

        System.out.print("Введите число: ");
        userNum = in.nextInt();

        if (userNum >= 5 && userNum <= 10){
            System.out.println("Число попадает в диапозон от 5 до 10 включительно");
        } else {
            System.out.println("Число не попадает в диапозон от 5 до 10 включительно");
        }
    }

    public static void Ex5(){

        Scanner in = new Scanner(System.in);
        int userNum;

        System.out.print("Введите число: ");
        userNum = in.nextInt();

        if (userNum < 1000){
            System.out.println("В Вашем числе нет тысяч!");
        } else {
            int thousands = (userNum / 1000) % 10;

            System.out.println("В Вашем числе " + thousands + " тысяч!");
        }
    }

    public static void Ex6(){

        Scanner in = new Scanner(System.in);
        int firstNum, secondNum;

        System.out.print("Введите первое число: ");
        firstNum = in.nextInt();
        System.out.print("Введите второе число: ");
        secondNum = in.nextInt();

        System.out.println("Сумма введенных чисел равна " +
                (firstNum + secondNum));
    }

    public static void Ex6_1(){

        Scanner in = new Scanner(System.in);
        int firstNum, secondNum;
        JFrame frame = new JFrame();

        firstNum = Integer.parseInt(JOptionPane.showInputDialog(frame, "Введите первое число: "));
        secondNum = Integer.parseInt(JOptionPane.showInputDialog(frame, "Введите второе число: "));

        JOptionPane.showMessageDialog(frame, "Сумма двух чисел равна "
                + (firstNum + secondNum));
    }

    public static void Ex7(){

        Scanner in = new Scanner(System.in);
        int userNum;

        System.out.print("Введите число: ");
        userNum = in.nextInt();

        System.out.println("Полученная последовательность: " +
                (userNum - 1) + ", " +
                userNum + ", " +
                (userNum + 1));
    }

    public static void Ex7_1(){

        Scanner in = new Scanner(System.in);
        int userNum;
        JFrame frame = new JFrame();

        userNum = Integer.parseInt(JOptionPane.showInputDialog(frame, "Введите число: "));

        JOptionPane.showMessageDialog(frame, "Полученная последовательность "
                + (userNum - 1) + ", " + userNum + ", " + (userNum + 1));
    }

    public static void Ex8(){

        Scanner in = new Scanner(System.in);
        int firstNum, secondNum;

        System.out.print("Введите первое число: ");
        firstNum = in.nextInt();
        System.out.print("Введите второе число: ");
        secondNum = in.nextInt();

        System.out.println("Сумма " + firstNum + " и " + secondNum + " равна " +
                (firstNum + secondNum));
        System.out.println("Разность " + firstNum + " и " + secondNum + " равна " +
                (firstNum - secondNum));
        System.out.println("Разность " + secondNum + " и " + firstNum + " равна " +
                (secondNum - firstNum));
    }

    public static void Ex8_1(){

        Scanner in = new Scanner(System.in);
        int firstNum, secondNum;
        JFrame frame = new JFrame();

        firstNum = Integer.parseInt(JOptionPane.showInputDialog(frame, "Введите первое число: "));
        secondNum = Integer.parseInt(JOptionPane.showInputDialog(frame, "Введите второе число: "));

        JOptionPane.showMessageDialog(frame, "Сумма " + firstNum + " и " + secondNum + " равна " +
                (firstNum + secondNum) +
                "\nРазность " + firstNum + " и " + secondNum + " равна " +
                (firstNum - secondNum) +
                "\nРазность " + secondNum + " и " + firstNum + " равна " +
                (secondNum - firstNum));
    }
}