package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        firstMeth();
        secondMeth();
    }
    public static void firstMeth(){
        int size = 10_000_000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long time = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения в один поток: " + (System.currentTimeMillis() - time) + " мс");
    }
    public static void secondMeth() throws InterruptedException {

        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] array = new float[SIZE];
        Arrays.fill(array, 1.0f);
        long startTime = System.currentTimeMillis();

        //start
        float[] leftArray = new float[HALF];
        float[] rightArray = new float[HALF];
        System.arraycopy(array, 0, leftArray, 0, HALF);
        System.arraycopy(array, HALF, rightArray, 0, HALF);

        Thread f = new Thread(() -> {
            for(int i = 0; i < leftArray.length; i++){
                leftArray[i] = (float)(leftArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });
        Thread s = new Thread(() -> {
            for(int i = HALF; i < rightArray.length + HALF; i++){
                rightArray[i - HALF] = (float)(rightArray[i - HALF] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });

        f.start();
        s.start();
        f.join();
        s.join();

        float[] newArray = new float[SIZE];
        System.arraycopy(leftArray, 0, newArray, 0, HALF);
        System.arraycopy(rightArray, 0, newArray, HALF, HALF);
        //end

        System.out.println("Время выполнения в два потока: " + (System.currentTimeMillis() - startTime) + " мс");
    }
}
