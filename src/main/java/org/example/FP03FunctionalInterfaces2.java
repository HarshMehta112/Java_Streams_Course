package org.example;

import java.util.Map;
import java.util.Random;
import java.util.function.*;

/**
 * Description:
 * Author: Harsh Mehta
 * Date: 5/29/24 10:03 AM
 */
public class FP03FunctionalInterfaces2
{
    public static void main(String[] args)
    {

        //StringOutput Function

        Function<Integer,String> function = num -> num + "";

        System.out.println(function.apply(12));

        // supplier does not take any argument and returns somthing.

        //i.e want to return random number
        Supplier<Integer> supplier = () -> {
            Random random = new Random();
            return random.nextInt(10000);
        };

        System.out.println(supplier.get());

        /** One point remember that when Operator name occures
         * it means it will accept the data type and same data type will return*/

        // unaryOperator that accepts one argument and return same type of data structure of argument

        UnaryOperator<Integer> unaryOperator = num -> 3*num;

        System.out.println(unaryOperator.apply(2));

        //BiPredicate it accepts two argument and return boolean

        BiPredicate<Integer,Integer> biPredicate = (x,y) -> x > y;

        System.out.println(biPredicate.test(1,2));

        //BiFunction accepts two argument and returns as mentioned datatype

        BiFunction<Integer,String,Integer> biFunction = (length,str) -> Math.abs(str.length()-length);

        System.out.println(biFunction.apply(3,"Harsh"));

        // Biconsumer accepts two argument and returns void

        BiConsumer<Integer,String> biConsumer = (num,str) ->
        {
            System.out.println(num);

            System.out.println(str);
        };

        biConsumer.accept(10,"Harsh");
    }
}
