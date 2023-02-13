package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ex3();
    }

    public static void ex1(){

        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int len;

        System.out.println("Введите длину массива: ");
        len = in.nextInt();
        Integer[] array = new Integer[len];
        for (int i = 0; i < len; i++){
            array[i] = rand.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        Arrays.sort(array, Collections.reverseOrder());
        for(int i : array){
            System.out.print(i + " ");
        }
    }

    public static void ex2(){

        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int len;

        System.out.println("Введите длину массива: ");
        len = in.nextInt();
        Character[] array = new Character[len];
        for (int i = 0; i < len; i++){
            array[i] = (char)rand.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();


        char item;
        for (int i = 0; i < len / 2; i++){
            item = array[i];
            array[i] = array[len - i - 1];
            array[len - i - 1] = item;
        }

        for(char i : array){
            System.out.print(i + " ");
        }
    }

    public static void ex3(){

        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int columns, rows;

        System.out.println("Введите кoличество столбцов: ");
        columns = in.nextInt();
        System.out.println("Введите кoличество строк: ");
        rows = in.nextInt();

        int[][] firstArray = new int[rows][columns];
        int[][] secondArray = new int[columns][rows];
        System.out.println("Первый массив: ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                firstArray[i][j] = rand.nextInt(10);
                System.out.print(firstArray[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Второй массив: ");
        for(int i = 0; i < columns; i++){
            for(int j = 0; j < rows; j++){
                secondArray[i][j] = firstArray[j][i];
                System.out.print(secondArray[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
