/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author BM
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
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
        return maxSum;
    }

    public static List[] splitArray(List<Integer> array) {
        List[] splittedArray;
        splittedArray = new List[2];

        splittedArray[0] = new ArrayList(array.subList(0, array.size() / 2));

        splittedArray[1] = new ArrayList(array.subList(array.size() / 2, array.size()));

        return splittedArray;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        List<Integer> arrays = Arrays.asList(4, -3, 2, 1, 6, -1, -2, 4);

        System.out.println(splitArray(arrays)[0]);
        System.out.println(splitArray(arrays)[1]);

        System.out.println(maxSum(splitArray(arrays)[0]));
        System.out.println(maxSum(splitArray(arrays)[1]));

    }

}
