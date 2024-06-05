package org.example;

import java.util.List;

/**
 * Author: Harsh Mehta
 * Date: 04/04/24 11:06 am
 */


/**
 *
 * Concept of Method Reference in Java.
 * --> Functional Interface in Java -- https://www.geeksforgeeks.org/functional-interfaces-java/
 * */



public class FP02StructuredApproach
{
    public static void main(String[] args) {

        /** first we have to print all the numbers present in the list in structured way*/

        int sum = printSumOfAllNumbersStructuredWay(List.of(1,2,3,4,5,6,7,8,9,10));

        System.out.println(sum);
    }

    private static int printSumOfAllNumbersStructuredWay(List<Integer> list) {

        /** When we have to do this we think how I loop the number add to it in sum variable and How I print it*/

        int sum=0;

        for(int num : list)
        {
            sum+=num;
        }

        return sum;
    }
}
