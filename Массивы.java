package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    static int[] array;
    static int[][] dArray;
    static int userNum, size, minValue, maxValue, sumLeft = 0 ,sumRight = 0;
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] arg){

        Ex8();
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

    public static void Ex4(){

        System.out.print("Введите размер массива: ");
        userNum = in.nextInt();
        dArray = new int[userNum][userNum];

        for (int i = 0; i < userNum; i++){
            for (int j = 0; j < userNum; j++){
                dArray[i][j] = i == j || i == userNum - j - 1 ? 1 : 0;
                System.out.print(dArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void Ex5(){

        System.out.print("Введите длину массива: ");
        size = in.nextInt();
        System.out.print("Введите значение: ");
        userNum = in.nextInt();

        array = methodForEx5(size, userNum);
        System.out.println(Arrays.toString(array));
    }
    public static int[] methodForEx5(int len, int initialValue){

        Arrays.fill(array = new int[size], initialValue);
        return array;
    }
    public static void Ex6(){

        System.out.print("Введите длину массива: ");
        size = in.nextInt();
        array = new int[size];

        for (int i = 0; i < size; i++){
            array[i] = rand.nextInt(10);
        }
        System.out.println(Arrays.toString(array));

        minValue = array[0];
        maxValue = array[0];
        for (int item : array){
            if (minValue > item) minValue = item;
            if (maxValue < item) maxValue = item;
        }
        System.out.println("Минимальное значение: " + minValue);
        System.out.println("Максимальное значение: " + maxValue);
    }
    public static void Ex7(){

        System.out.print("Введите длину массива: ");
        size = in.nextInt();
        array = new int[size];

        for (int i = 0; i < size; i++){
            array[i] = rand.nextInt(10);
        }

        System.out.println(Arrays.toString(array));
        System.out.println("Результат: " + methodEx7(array));
    }
    public static boolean methodEx7(int[] array){

        for (int i = 0; i < array.length - 1; i++){

            for(int j = 0; j <= i; j++) sumLeft += array[j];
            for(int k = i + 1; k < array.length; k++) sumRight += array[k];
            if (sumLeft == sumRight) {
                System.out.println(sumLeft + " " + sumRight);
                return true;
            }
            sumRight = 0;
            sumLeft = 0;
        }
        return false;
    }
    public static void Ex8(){

        System.out.print("Введите длину массива: ");
        size = in.nextInt();
        array = new int[size];

        for (int i = 0; i < size; i++){
            array[i] = rand.nextInt(10);
        }

        System.out.println(Arrays.toString(array));
        System.out.print("На сколько сдвинуть числа? ");
        userNum = in.nextInt();
        methodEx8(array, userNum);
    }
    public static void methodEx8(int[] array, int userNum){

        if (userNum > 0)
            for (int i = 0; i < userNum; i++){
                int a = array[0];
                array[0] = array[array.length - 1];
                for (int j = 1; j < array.length; j++){
                    int b = array[j];
                    array[j] = a;
                    a = b;
                }
        }
        else
            for (int i = 0; i < abs(userNum); i++){
                int a = array[array.length - 1];
                array[array.length - 1] = array[0];
                for (int j = array.length - 2; j >= 0 ; j--){
                    int b = array[j];
                    array[j] = a;
                    a = b;
                }
            }

        System.out.println(Arrays.toString(array));
    }
}
