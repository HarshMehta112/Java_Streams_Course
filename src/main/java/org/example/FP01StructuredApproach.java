package org.example;

import java.util.List;

/**
 * Description:
 * Author: Harsh Mehta
 * Date: 04/04/24 11:06 am
 */


/**
 *
 * Concept of Method Reference in Java.
 * --> Functional Interface in Java -- https://www.geeksforgeeks.org/functional-interfaces-java/
 *
 *
 * */



public class FP01StructuredApproach
{
    public static void main(String[] args) {

        /** first we have to print all the numbers present in the list in structured way*/

        printAllNumberStructuredWay(List.of(10,29,9,4,5,7,330));
    }

    private static void printAllNumberStructuredWay(List<Integer> list) {

        /** When we have to do this we think how I loop the number and How I print it*/

        for(int num : list)
        {
            System.out.println(num);
        }
    }
}
