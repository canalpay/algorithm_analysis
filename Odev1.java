package org.canalpay.algorithm.analysis;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

/**
 * Created by canalpay on 3/12/17.
 */
public class Odev1 {

    public static int maxSum(List<Integer> array) {
        int sum = 0;
        int maxSum = 0;


        for (int i = 0; i < array.size(); i++) {
            for (int j = i; j < array.size(); j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + array.get(k);
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }

            }
        }
        System.out.println("iterative");
        return maxSum;
    }

    public static Integer findMaxInTriple(int a, int b, int c) {

        if (a > b) {
            if (b > c || a > c) {
                return a;
            } else {
                return c;
            }
        } else if (b > c) {
            return b;
        } else {
            return c;
        }

    }



    public static Integer findMiddle(List<Integer> array) {
//        middle =int(len(list) / 2)

        int middle = array.size() / 2;
        int sumLeftMax = 0;
        int sumLeft = 0;
        for (int i = middle - 1; i > -1; i--) {
            sumLeft = sumLeft + array.get(i);
            if (sumLeft > sumLeftMax) {
                sumLeftMax = sumLeft;
            }
        }


        int sumRightMax = 0;
        int sumRight = 0;
        for (int i = middle; array.size() > i; i++) {
            sumRight = sumRight + array.get(i);
            if (sumRight > sumRightMax) {
                sumRightMax = sumRight;
            }
        }


        return sumLeftMax + sumRightMax;
    }


    public static Integer maxSumAsRecursive(List<Integer> array) {
        if (array.size() < 2) {
            return array.get(0);
        } else {
            int middle = array.size() / 2;
            int sumLeft = maxSumAsRecursive(splitArray(array)[0]);
            int sumRight = maxSumAsRecursive(splitArray(array)[1]);
            int sumMiddle = findMiddle(array);
            return findMaxInTriple(sumLeft, sumRight, sumMiddle);
        }

    }





    public static List[] splitArray(List<Integer> array) {
        List[] splittedArray;
        splittedArray = new List[2];

        splittedArray[0] = new ArrayList(array.subList(0, array.size() / 2));

        splittedArray[1] = new ArrayList(array.subList(array.size() / 2, array.size()));

        return splittedArray;
    }


    public static List<Integer> generateRandomNumbers(int size, int minBorderInclusive, int maxBorderExclusive) {

        List<Integer> integerList = new ArrayList<Integer>();

        Random random = new Random();

        for (int i = 0; i < size ; i++) {
            integerList.add(random.nextInt((maxBorderExclusive - minBorderInclusive) + 1) + minBorderInclusive);
        }

        return integerList;

    }


    public static void main(String[] args) {
        // TODO code application logic here

//        List<Integer> arrays = Arrays.asList(4, -3, 2, 1, 6, -1, -2, 4);

        System.out.println("-------------");
        System.out.println("-------------");
        runInTwoAlgo(10,1,10000);
        System.out.println("-------------");
        System.out.println("-------------");

        runInTwoAlgo(100,1,10000);
        System.out.println("-------------");
        System.out.println("-------------");

        runInTwoAlgo(1000,1,10000);
        System.out.println("-------------");
        System.out.println("-------------");

        runInTwoAlgo(10_000,1,10000);
        System.out.println("-------------");
        System.out.println("-------------");

    //    runInTwoAlgo(100_000,1,1000);


    }

    private static void runInTwoAlgo(int size, int minBorderInclusive, int maxBorderExcusive) {
        List<Integer> arrays = generateRandomNumbers(size, minBorderInclusive, maxBorderExcusive);

//        System.out.println("Size :" + size + "  Min :" + minBorderInclusive + "  Max" + maxBorderExcusive);
//        System.out.println("Array : " + arrays);
        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(getRunnable(arrays, (a) ->{
       //     System.out.println("İterative Fonksiyon");
            return Odev1.maxSum(a);
        }));
        executor.execute(getRunnable(arrays,(b)-> {
      //      System.out.println("Recursive Fonksiyon");
            return  Odev1.maxSumAsRecursive(b);
        }));
    }

    private static Runnable getRunnable(List<Integer> arrays, Function<List<Integer>,Integer> intFunction) {
        return ()->
        {
          //  System.out.println(intFunction.toString());
            long a = System.currentTimeMillis();
            System.out.println("En büyük alt dizinin toplamı :" + intFunction.apply(arrays));
            long b = System.currentTimeMillis();
            System.out.println("Süre :"  +(b-a));
            System.out.println("Size :" + arrays.size());
            System.out.println("Array : " + arrays);
        };
    }


}
