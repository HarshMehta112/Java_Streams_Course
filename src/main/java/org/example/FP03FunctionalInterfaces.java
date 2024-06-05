package org.example;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Description:
 * Author: Harsh Mehta
 * Date: 5/28/24 9:16 AM
 */
public class FP03FunctionalInterfaces
{

    private static Predicate<Integer> isEvenPredicate = number -> number % 2 == 0;

    private static BinaryOperator<Integer> binaryOperator = Integer::sum;

    private static BinaryOperator<Integer> binaryOperator2 = new BinaryOperator<Integer>() {
        @Override
        public Integer apply(Integer integer, Integer integer2) {
            return integer+integer2;
        }
    };

    // Java internally does this thing

    // one input boolean output then always go for Predicate

    static Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return integer%2==0;
        }
    };
    private static Function<Integer, Integer> squareFunction = number -> number * number;

    //one input one output then always go for Function

    static Function<Integer,Integer> squareFunction2 = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer integer) {
            return integer*integer;
        }
    };
    private static Consumer<Integer> sysoutConsumer = System.out::println;

    static Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
        @Override
        public void accept(Integer integer) {
            System.out.println(integer);
        }
    };

    public static void main(String[] args)
    {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8);

        /**
         * I want to print list of squares of even numbers
         * */

        numbers.stream()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(sysoutConsumer);

        System.out.println("-----------------------Manually----------------------------");

        numbers.stream()
                .filter(isEvenPredicate2)
                .map(squareFunction2)
                .forEach(sysoutConsumer2);

        System.out.println("-----------------------Sum using Reduce function---------------");

        int sum = numbers.stream().reduce(0, binaryOperator);

        System.out.println(sum);

        sum = numbers.stream().reduce(0, binaryOperator2);

        System.out.println(sum);

    }
}
