package com.company;

import java.util.Arrays;

/**
 * Created by BM on 17.03.2017.
 */
public class Hafta4 {
    private int capacity = 5;
    private int[] array = new int[capacity];
    private int size = 0;


    // BigO(N)
    public void add(int number) {

        // Best Case : 1
        if (ensureCapacity()) {
            array[size] = number;

        } else {

            //Worst Case : n
            int[] temp = Arrays.copyOf(array, size);
            capacity *= 2;
            array = new int[capacity];
            for (int i =0; i < size;
                 i++) {
                array[i] = temp[i];
            }

            array[size] = number;
        }
        size++;
    }
    private boolean ensureCapacity() {
        if (capacity > size) {
            return true;
        }else{
            return  false;
        }
    }

    public static void main(String[] args) {
        // write your code here
        Hafta4 myArrayList = new Hafta4();


        Hafta4 myArrayList2;
        for (int i = 5; i <100 ; i++) {
            myArrayList.add(i);
        }

        //Shallow
        //O(1)
        myArrayList2 = myArrayList;

    }


}
