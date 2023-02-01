package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Ex2();
    }

    public static void Ex1(){

        int size;
        int number = 0;
        int[] mass;
        Scanner in = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        size = in.nextInt();
        mass = new int[size];

        for(int i = 0; i < size; number++){
            if(number % 5 == 2){
                mass[i] = number;
                i++;
            }
        }

        for(int i : mass)
            System.out.println(i);
    }

    public static void Ex2(){

        char symbol = 'a';
        int size = 10;

        char[] mass = new char[size];

        for (int i = 0; i < 10; i++){
            mass[i] = (char)((int)symbol + 2*i);
        }

        for(char i : mass){
            System.out.println(i);
        }
    }
}