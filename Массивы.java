package org.example;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {

    static int[] array;
    static int userNum, size;
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] arg){

        Ex3();
    }
    public static void Ex1(){

        System.out.print("Введите длину массива: ");
        userNum = in.nextInt();

        array = new int[userNum];
        System.out.print("Исходный массив:   ");
        for (int i = 0; i < userNum; i++){
            array[i] = rand.nextInt(2);
            System.out.print(array[i] + " ");
        }

        System.out.print("\nИзмененный массив: ");
        for (int i = 0; i < userNum; i++){
            array[i] = (array[i] == 0 ? 1 : 0);
            System.out.print(array[i] + " ");
        }
    }
    public static void Ex2(){

        size = 100;
        array = new int[size];

        System.out.println("Массив: ");
        for (int i = 0; i < size; i++){
            array[i] = i + 1;
            System.out.print(array[i] + " ");
        }
    }

    public static void Ex3(){

        array = new int [] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.print("Исходный массив: ");
        for (int item : array) System.out.print(item + " ");

        System.out.print("\nИзмененный массив: ");
        for (int i = 0; i < array.length; i++){

            array[i] = array[i] < 6 ? array[i] * 2 : array[i];
            System.out.print(array[i] + " ");
        }
    }
}
