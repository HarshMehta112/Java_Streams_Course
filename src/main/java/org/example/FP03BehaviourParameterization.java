package org.example;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Description:
 * Author: Harsh Mehta
 * Date: 5/29/24 9:26 AM
 */
public class FP03BehaviourParameterization
{
    public static final Predicate<Integer> EVEN_PREDICATE = n -> n % 2 == 0;

    public static final Predicate<Integer> ODD_PREDICATE = n -> n % 2 != 0;

    public static void main(String[] args)
    {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8);

        //all even numbers
        numbers.stream()
                .filter(EVEN_PREDICATE)
                .forEach(System.out::println);

        //all odd numbers
        numbers.stream()
                .filter(ODD_PREDICATE)
                .forEach(System.out::println);

        filterAndPrint(numbers,ODD_PREDICATE);

        System.out.println("----------------------------------------------");

        filterAndPrint(numbers,EVEN_PREDICATE);

        filterAndPrint(numbers, n -> n % 2 == 0);

        System.out.println("----------------------------------------------");

        filterAndPrint(numbers,n -> n % 2 != 0);

        /**
         * Here in above two methods logic is same and code is also same.
         * there is only change in behaviour of the method.
         *
         * Here we are passing the algorithm or code as an argument so it is called behaviour parameterization.
         * */

        System.out.println(multiplyAndReturn(numbers,n -> n*n));
        System.out.println(multiplyAndReturn(numbers,n -> n*n*n));

    }

    public static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate)
    {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    /** Excersise */

    public static List<Integer> multiplyAndReturn(List<Integer> numbers, Function<Integer,Integer> function)
    {
        return numbers.stream()
                .map(function)
                .collect(Collectors.toList());
    }
}
