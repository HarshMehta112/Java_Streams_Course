package org.example;

import java.util.List;

/**
 * Description:
 * Author: Harsh Mehta
 * Date: 04/04/24 11:06 am
 */
public class FP01FunctionalApproach
{
    public static void main(String[] args) {

        /** first we have to print all the numbers present in the list in functional way*/

//        printAllNumberFunctionalWay(List.of(10,29,9,4,5,7,330));

        printEvenNumberFunctionalWay(List.of(10,29,9,4,5,7,330));

    }

    private static void print(int number)
    {
        System.out.println(number);
    }

  /*  private static void printAllNumberFunctionalWay(List<Integer> list) {

        *//** When we have to do this we think What to do?? Need to convert list of numbers to stream of numbers*//*

        list.stream().forEach(FP01FunctionalApproach::print); // :: is Method reference
    }*/

    private static void printAllNumberFunctionalWay(List<Integer> list) {

        /** When we have to do this we think What to do?? Need to convert list of numbers to stream of numbers*/

        list.stream().forEach(System.out::println); // :: is Method reference

    }

    private static void printEvenNumberFunctionalWay(List<Integer> list) {

        /** When we have to do this we think What to do?? Need to convert list of numbers to stream of numbers*/

        list.stream().filter(n->n%2==0).forEach(System.out::println);// :: is Method reference

        /** Here we are not calling println method we are saying for each number call print method
         * Here I used the lamda expression to check the number is odd or even
         * */
    }
}
