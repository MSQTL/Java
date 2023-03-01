package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static boolean flag = false, flagAI = false;
    public static int sumDots = 0;
    public static int SIZE;
    public static int DOTS_TO_WIN;
    public static int COORD_X, COORD_Y;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map, checkMap;
    public static Scanner in = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {

        level();
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void level(){

        System.out.print("Выберите размер поля: ");
        SIZE = in.nextInt();
        System.out.print("Выберите количество символов для победы: ");
        DOTS_TO_WIN = in.nextInt();
    }

    public static boolean checkForAI(char symb){

        //горизонтали
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(map[i][j] == symb) sumDots += 1;
                else sumDots = 0;
                if(sumDots == DOTS_TO_WIN - 1) {
                    flagAI = true;
                    COORD_X = j + 1;
                    COORD_Y = i;
                }
            }
        }
        if(flagAI) return true;
        sumDots = 0;
        //вертикали
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(map[j][i] == symb) sumDots += 1;
                else sumDots = 0;
                if(sumDots == DOTS_TO_WIN - 1) {
                    flagAI = true;
                    COORD_X = i;
                    COORD_Y = j + 1;
                }
            }
        }
        sumDots = 0;

        return flagAI;
    }

    public static boolean checkWin(char symb) {

        checkMap = new char[DOTS_TO_WIN][DOTS_TO_WIN];

        for(int n = 0; n < SIZE - DOTS_TO_WIN + 1; n++){
            for(int m = 0; m < SIZE - DOTS_TO_WIN + 1; m++){
                //заполнение массива
                for(int i = 0; i < DOTS_TO_WIN; i++){
                    for(int j = 0; j < DOTS_TO_WIN; j++){
                        checkMap[i][j] = map[i + n][j + m];
                    }
                }
                //главная диагональ
                for(int i = 0; i < DOTS_TO_WIN; i++){
                    for(int j = 0; j < DOTS_TO_WIN; j++){
                        if(i == j){
                            if(checkMap[i][j] == symb) sumDots += 1;
                            else sumDots = 0;
                            if(sumDots >= DOTS_TO_WIN) flag = true;
                        }
                    }
                }
                sumDots = 0;
                //побочная диагональ
                for(int i = 0; i < DOTS_TO_WIN; i++){
                    for(int j = 0; j < DOTS_TO_WIN; j++){
                        if(i == j){
                            if(checkMap[i][DOTS_TO_WIN - j - 1] == symb) sumDots += 1;
                            else sumDots = 0;
                            if(sumDots >= DOTS_TO_WIN) flag = true;
                        }
                    }
                }
                sumDots = 0;
            }
        }
        //горизонтали
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(map[i][j] == symb) sumDots += 1;
                else sumDots = 0;
                if(sumDots >= DOTS_TO_WIN) flag = true;
            }
        }
        sumDots = 0;
        //вертикали
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(map[j][i] == symb) sumDots += 1;
                else sumDots = 0;
                if(sumDots >= DOTS_TO_WIN) flag = true;
            }
        }
        return flag;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;

        if(checkForAI(DOT_X)){
            x = COORD_X;
            y = COORD_Y;
            flagAI = false;
            if(!isCellValid(x, y)){
                do {
                    x = rand.nextInt(SIZE);
                    y = rand.nextInt(SIZE);
                } while (!isCellValid(x, y));
            }
        }
        else {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
        }
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = in.nextInt() - 1;
            y = in.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++){
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
